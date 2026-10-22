package org.chromium;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.e.i;
import com.bytedance.frameworks.baselib.network.http.cronet.e.l;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTAppSecurityManager;
import com.ttnet.org.chromium.net.TTNetVersion;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestMapping;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import d.b.h.a.a.h.s.h;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.Executor;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    private static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    private static final String KEY_REQUEST_LOG = "request_log";
    private static final String KEY_TTNET_CRASH_TIMES = "ttnet_crash_times";
    private static final int MAX_THREAD_STACK_SIZE = 5242880;
    private static final int MIN_THREAD_STACK_SIZE = 51200;
    private static final String SP_SS_APP_CONFIG = "ss_app_config";
    public static final String TAG = "CronetClient";
    private static final String TTNET_ALOG_CLASS = "com.bytedance.ttnet.TTALog";
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CACHE_DIR = "ttnet_storage/";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static int sAppID = 0;
    private static ICronetClient.ICronetBootFailureCheckerProvider sCronetBootFailureCheckerProvider = null;
    private static volatile CronetEngine sCronetEngine = null;
    private static ICronetClient.ICronetThreadStackOptFailureCheckerProvider sCronetThreadStackOptFailureCheckerProvider = null;
    private static volatile int sNetworkThreadPriority = 20;
    private static volatile RequestFinishedInfo.Listener sRequestFinishedInfoListener;
    private int mCrashDetectTimerInterval;
    private int mCrashLimitTimes;
    private int mTTNetCrashTimes;

    static {
    }

    public CronetClient() {
        this.mCrashLimitTimes = 0;
        this.mCrashDetectTimerInterval = 5000;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences INVOKEVIRTUAL_org_chromium_CronetClient_com_obric_matrix_SPLancet_getSharedPreferences2(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ long access$000(long r0, long r2) {
        return getCostTime(r0, r2);
    }

    private TTAppInfoProvider.AppInfo convertToCronetAppInfo(com.bytedance.frameworks.baselib.network.http.cronet.b r2) {
        TTAppInfoProvider.AppInfo r1 = new TTAppInfoProvider.AppInfo();
        r1.setAbSdkVersion(r2.f4684a);
        r1.setHostFirst(r2.f4685b);
        r1.setHostSecond(r2.f4686c);
        r1.setHostThird(r2.f4687d);
        r1.setDomainHttpDns(r2.f4688e);
        r1.setDomainBoe(r2.f4689f);
        r1.setDomainBoeHttps(r2.f4690g);
        r1.setInitRegion(r2.f4691h);
        return r1;
    }

    private static TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting(d.b.h.a.a.k.c r5) {
        if (r5 != null) goto L18;
        return null;
    L18:
        d.b.h.a.a.k.b r1 = r5.d();     // Catch: Exception -> L15
        if (r1 == null) goto L8;
        TTSamplingSettingProvider.TTSlaSamplingRule r2 = new TTSamplingSettingProvider.TTSlaSamplingRule();     // Catch: Exception -> L15
        r2.mEnableBaseApiAll = r1.b();     // Catch: Exception -> L15
        r2.mEnableApiAllUpload = r1.a();     // Catch: Exception -> L15
        r2.mUrlRegexBlackList = r1.h();     // Catch: Exception -> L15
        r2.mPathEqualWhiteList = r1.e();     // Catch: Exception -> L15
        r2.mPathPrefixWhiteList = r1.f();     // Catch: Exception -> L15
        r2.mPathContainWhiteList = r1.d();     // Catch: Exception -> L15
        r2.mPathRegexWhiteList = r1.g();     // Catch: Exception -> L15
        r2.mHostPatternWhiteList = r1.c();     // Catch: Exception -> L15
        r2.mUrlRegexWhiteList = r1.i();     // Catch: Exception -> L15
    L9:
        d.b.h.a.a.k.a r3 = r5.c();     // Catch: Exception -> L15
        if (r3 == null) goto L12;
        TTSamplingSettingProvider.TTEventLogSamplingRule r4 = new TTSamplingSettingProvider.TTEventLogSamplingRule();     // Catch: Exception -> L15
        r4.mEventLogTypeWhiteList = r3.a();     // Catch: Exception -> L15
    L13:
        TTSamplingSettingProvider.TTSlaSamplingSetting r6 = new TTSamplingSettingProvider.TTSlaSamplingSetting();     // Catch: Exception -> L15
        r6.mHostAid = r5.a();     // Catch: Exception -> L15
        r6.mSdkAid = r5.b();     // Catch: Exception -> L15
        r6.mSlaSamplingRule = r2;     // Catch: Exception -> L15
        r6.mEventLogSamplingRule = r4;     // Catch: Exception -> L15
        return r6;
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void detectCronetColdStartCrash(final Context r11, ExperimentalCronetEngine.Builder r12) {
        SharedPreferences r0 = INVOKEVIRTUAL_org_chromium_CronetClient_com_obric_matrix_SPLancet_getSharedPreferences2(r11, SP_SS_APP_CONFIG, 0);
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
        Logger.d(TAG, "processname is " + h.a(r11) + " count is " + this.mTTNetCrashTimes + " limit is " + this.mCrashLimitTimes + " interval is " + this.mCrashDetectTimerInterval);
    L15:
        if (this.mTTNetCrashTimes < this.mCrashLimitTimes) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "processname is " + h.a(r11) + "set secure mode true");
    L19:
        r12.enableTncSecureMode(true);
    L21:
        if (h.h(r11) == true) goto L23;
        return;
    L23:
        final SharedPreferences.Editor r7 = r0.edit();
        int r5 = this.mTTNetCrashTimes + 1;
        this.mTTNetCrashTimes = r5;
        r7.putInt(KEY_TTNET_CRASH_TIMES, r5);
        r7.commit();
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "processname is " + h.a(r11) + " save count " + this.mTTNetCrashTimes);
    L26:
        d.b.h.a.a.d.c r8 = d.b.h.a.a.d.c.c(d.b.h.a.a.d.d.f13252f);
        final long r6 = this.mCrashDetectTimerInterval;
        final long r9 = 0;
        r8.d(new AnonymousClass1(this, r6, r9, r11, r7));
    }

    private static long getALogFuncAddr() {
        return ((Long) Reflect.on(Class.forName(TTNET_ALOG_CLASS).newInstance()).call("getALogFuncAddr").get()).longValue();
    }

    private static int getAppSecurityLevel() {
        return ((Integer) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getAppSecurityLevel").get()).intValue();
    L4:
        return 0;
    }

    private static long getCostTime(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r3 == (-1)) goto L11;
        if (r5 > r3) goto L11;
        return r3 - r5;
    }

    public static CronetEngine getCronetEngine() {
        Objects.requireNonNull(sCronetEngine, "Cronet engine is null.");
        return sCronetEngine;
    }

    private static String getDomainConfigByRegion() {
        String r0 = c.W().h();
        String r1 = c.W().K();
        String r2 = c.W().D();
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

    private static boolean getListenAppStateIndependently() {
        return ((Boolean) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getListenAppStateIndependently").get()).booleanValue();
    L4:
        return false;
    }

    private static long getMaxHttpDiskCacheSize() {
        return ((Long) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getMaxHttpDiskCacheSize").get()).longValue();
    L4:
        return 67108864;
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
    L37:
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

    private static JSONObject getSlaSamplingSetting() {
        return (JSONObject) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getSlaSamplingSetting").get();
    L4:
        return null;
    }

    private static com.bytedance.frameworks.baselib.network.http.cronet.c.a getThreadConfigCallbackImpl() {
        return (com.bytedance.frameworks.baselib.network.http.cronet.c.a) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigCallbackImpl").get();
    L4:
        return null;
    }

    private static ArrayList<com.bytedance.frameworks.baselib.network.http.cronet.c> getThreadConfigInfoList() {
        return (ArrayList) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigInfoList").get();
    L4:
        return null;
    }

    private static long getTime(Date r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.getTime();
    }

    private static long getValue(Long r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.longValue();
    }

    public static void setAppStartUpState(int r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAppStartUpState(r1);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setNetworkThreadPriority(int r0) {
        sNetworkThreadPriority = r0;
    }

    private void tryCreateRequestFinishedInfoListener(final Executor r3) {
        if (sRequestFinishedInfoListener == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sRequestFinishedInfoListener == null) goto L10;
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L13
        return;
    L10:
        sRequestFinishedInfoListener = new AnonymousClass5(this, r3);     // Catch: Throwable -> L13
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void addClientOpaqueData(String[] r9, byte[] r10, byte[] r11, long r12, long r14) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).addClientOpaqueData(r9, r10, r11, r12, r14);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindBigCore(com.bytedance.frameworks.baselib.network.http.cronet.c.EnumC0148c r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindBigCore(r1.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindLittleCore(com.bytedance.frameworks.baselib.network.http.cronet.c.EnumC0148c r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindLittleCore(r1.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void clearClientOpaqueData() {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "clearClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).clearClientOpaqueData();     // Catch: Throwable -> L9
        return;
    }

    TTThreadConfigInfoProvider.Callback convertToCronetThreadConfigCallback(final com.bytedance.frameworks.baselib.network.http.cronet.c.a r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass2(this, r2);
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList(ArrayList<com.bytedance.frameworks.baselib.network.http.cronet.c> r9, boolean r10) {
        if (r9 != null) goto L40;
    L39:
        return null;
    L40:
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L5:
        if (r9.isEmpty() == true) goto L39;
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r0 = new ArrayList();     // Catch: Exception -> L37
        EnumSet r1 = EnumSet.noneOf(com.bytedance.frameworks.baselib.network.http.cronet.c.EnumC0148c.class);     // Catch: Exception -> L37
        Iterator<com.bytedance.frameworks.baselib.network.http.cronet.c> r11 = r9.iterator();     // Catch: Exception -> L37
    L8:
        if (r11.hasNext() == false) goto L36;
        com.bytedance.frameworks.baselib.network.http.cronet.c r2 = r11.next();     // Catch: Exception -> L37
        int r3 = r2.f4693b;     // Catch: Exception -> L37
        boolean r5 = true;
        if (r3 >= (-20)) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r10 == false) goto L22;
        int r6 = r2.f4694c;     // Catch: Exception -> L37
        if (r6 < MIN_THREAD_STACK_SIZE) goto L22;
        if (r6 > MAX_THREAD_STACK_SIZE) goto L22;
    L23:
        if (r4 == true) goto L27;
        if (r5 == false) goto L8;
    L27:
        if (r1.contains(r2.f4692a) == true) goto L8;
        TTThreadConfigInfoProvider.ThreadConfigInfo r7 = new TTThreadConfigInfoProvider.ThreadConfigInfo();     // Catch: Exception -> L37
        r7.setThreadType(TTThreadConfigInfoProvider.ThreadType.values()[r2.f4692a.ordinal()]);     // Catch: Exception -> L37
        if (r4 == false) goto L32;
        r7.setThreadPriority(r2.f4693b);     // Catch: Exception -> L37
    L32:
        if (r5 == false) goto L34;
        r7.setThreadStackSize(r2.f4694c);     // Catch: Exception -> L37
    L34:
        r0.add(r7);     // Catch: Exception -> L37
        r1.add(r2.f4692a);     // Catch: Exception -> L37
    L22:
        r5 = false;
        goto L23
    L13:
        if (r3 > 19) goto L15;
        r4 = true;
        goto L16
    L36:
        return r0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
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

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return TTNetVersion.VERSION;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveConnectionType() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveConnectionType();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveHttpRttMs() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveHttpRtt();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveRxThroughputKbps() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveRxThroughput();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveTransportRttMs() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveTransportRtt();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, com.bytedance.frameworks.baselib.network.http.cronet.e.h> getGroupRttEstimates() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ExperimentalCronetEngine r5 = (ExperimentalCronetEngine) sCronetEngine;
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, int[]>> r6 = r5.getGroupRttEstimates().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, int[]> r1 = r6.next();
        if (r1.getValue().length != 2) goto L11;
        com.bytedance.frameworks.baselib.network.http.cronet.e.h r2 = new com.bytedance.frameworks.baselib.network.http.cronet.e.h();
        int r3 = r1.getValue()[0];
        int r4 = r1.getValue()[1];
        r0.put(r1.getKey(), r2);
        goto L6
    L11:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L12:
        return r0;
    L14:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getMappingRequestState(final String r3) {
        CronetUrlRequest r0 = CronetUrlRequestMapping.GetRequest(r3);     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.getStatus(new AnonymousClass6(this, r3));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public com.bytedance.frameworks.baselib.network.http.cronet.e.h getNetworkQuality() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ExperimentalCronetEngine r1 = (ExperimentalCronetEngine) sCronetEngine;
        com.bytedance.frameworks.baselib.network.http.cronet.e.h r0 = new com.bytedance.frameworks.baselib.network.http.cronet.e.h();
        r1.getTransportRttMs();
        r1.getHttpRttMs();
        r1.getDownstreamThroughputKbps();
        return r0;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getNetworkQualityLevel() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getNetworkQualityLevel();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public i getPacketLossRateMetrics(int r2) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        i r1 = new i();
        ExperimentalCronetEngine r0 = (ExperimentalCronetEngine) sCronetEngine;
        r0.getUpstreamPacketLossRate(r2);
        r0.getUpstreamPacketLossRateVariance(r2);
        r0.getDownstreamPacketLossRate(r2);
        r0.getDownstreamPacketLossRateVariance(r2);
        return r1;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, Object> getRequestMetricsMap(HttpURLConnection r7) {
        LinkedHashMap r0 = null;
        if (r7 != null) goto L6;
        return null;
    L6:
        if (isCronetHttpURLConnection(r7) == true) goto L22;
        return null;
    L22:
        CronetHttpURLConnection r8 = (CronetHttpURLConnection) r7;     // Catch: Throwable -> L17
        RequestFinishedInfo r6 = r8.getRequestFinishedInfo();     // Catch: Throwable -> L17
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L17
        if (r6 != null) goto L20;
    L13:
        r1.put("request_log", r8.getRequestLog());     // Catch: Throwable -> L15
        return r1;
    L15:
        th = th;
        r0 = r1;
    L18:
        th.printStackTrace();
        return r0;
    L20:
        if (r6.getMetrics() == null) goto L13;
        RequestFinishedInfo.Metrics r9 = r6.getMetrics();     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_REMOTE_IP, r9.getPeerAddr() + ":" + r9.getPeerPort());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_DNS_TIME, Long.valueOf(getCostTime(getTime(r9.getDnsEnd()), getTime(r9.getDnsStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_CONNECT_TIME, Long.valueOf(getCostTime(getTime(r9.getConnectEnd()), getTime(r9.getConnectStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_SSL_TIME, Long.valueOf(getCostTime(getTime(r9.getSslEnd()), getTime(r9.getSslStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_SEND_TIME, Long.valueOf(getCostTime(getTime(r9.getSendingEnd()), getTime(r9.getSendingStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_PUSH_TIME, Long.valueOf(getCostTime(getTime(r9.getPushEnd()), getTime(r9.getPushStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_RECEIVE_TIME, Long.valueOf(getCostTime(getTime(r9.getRequestEnd()), getTime(r9.getResponseStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_SOCKET_REUSED, Boolean.valueOf(r9.getSocketReused()));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_TTFB, Long.valueOf(getValue(r9.getTtfbMs())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_TOTAL_TIME, Long.valueOf(getValue(r9.getTotalTimeMs())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_SEND_BYTE_COUNT, Long.valueOf(getValue(r9.getSentByteCount())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_RECEIVED_BYTE_COUNT, Long.valueOf(getValue(r9.getReceivedByteCount())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_RETRY_ATTEMPTS, Long.valueOf(getValue(r9.getRetryAttempts())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_REQUEST_HEADERS, r9.getRequestHeaders());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_RESPONSE_HEADERS, r9.getResponseHeaders());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_REQUEST_START, Long.valueOf(getTime(r9.getRequestStart())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_POST_TASK_START, Long.valueOf(getTime(r9.getPostTaskStartMs())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_WAIT_CONTEXT, Long.valueOf(getCostTime(getTime(r9.getRequestStart()), getTime(r9.getPostTaskStartMs()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_UPPER_ADD_COOKIE_US, r9.getAddCookieCostUs());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_UPPER_SAVE_COOKIE_US, r9.getSaveCookieCostUs());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_REQ_COOKIE_SOURCE_TYPE, r9.getRequestCookieSource());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_PRE_SAMPLING_REPORTABLE, Boolean.valueOf(r9.getPreSamplingReportable()));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_BYPASS_API_REPORT, Boolean.valueOf(r9.getBypassApiReport()));     // Catch: Throwable -> L15
    L17:
        th = th;
        goto L18
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r1) {
        return r1 instanceof CronetHttpURLConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyStoreRegionUpdated(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).updateStoreRegionFromServer(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean notifySwitchToMultiNetwork(boolean r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifySwitchToMultiNetwork(r1);
        return true;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyTNCConfigUpdated(String r8, String r9, String r10, String r11, String r12, String r13) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifyTNCConfigUpdated(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r13, String r14, boolean r15, String r16, boolean r17, Executor r18, ICronetAppProvider r19) {
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
        if (d.b.h.a.a.c.k().f13225a != d.b.h.a.a.c.b.f13237g) goto L5;
        d.b.h.a.a.c r0 = d.b.h.a.a.c.k();     // Catch: Throwable -> L7
        r0.f13225a = d.b.h.a.a.c.b.f13238h;     // Catch: Throwable -> L7
    L5:
        tryCreateCronetEngine(r13, false, false, false, r15, r16, r18, false, r19);     // Catch: Throwable -> L7
        return (HttpURLConnection) sCronetEngine.openConnection(new URL(r14), java.net.Proxy.NO_PROXY, r17);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void preconnectUrl(String r2, Map<String, String> r3) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).preconnectUrl(r2, 1, r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void removeClientOpaqueData(String r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).removeClientOpaqueData(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void reportNetDiagnosisUserLog(String r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).reportNetDiagnosisUserLog(r1);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void resetCoreBind(com.bytedance.frameworks.baselib.network.http.cronet.c.EnumC0148c r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).resetCoreBind(r1.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void runInBackGround(boolean r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "runInBackGround start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).runInBackGround(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAlogFuncAddr(long r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAlogFuncAddr(r1);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setBestHostWithRouteSelectionName(String r1, String r2) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setRouteSelectionBestHost(r1, r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCookieInitCompleted() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setCookieInitCompleted();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureCheckerProvider(ICronetClient.ICronetBootFailureCheckerProvider r1) {
        sCronetBootFailureCheckerProvider = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetThreadStackOptFailureCheckerProvider(ICronetClient.ICronetThreadStackOptFailureCheckerProvider r1) {
        sCronetThreadStackOptFailureCheckerProvider = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHostResolverRules(String r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setHostResolverRules(r1);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setProxy(String r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setProxy(r1);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setSlaSamplingSetting(JSONObject r1) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L10;
        TTSamplingSettingProvider.TTSlaSamplingSetting r0 = convertToCronetSlaSamplingSetting(d.b.h.a.a.k.d.a(r1, sAppID));
        if (r0 != null) goto L7;
        return;
    L7:
        ((ExperimentalCronetEngine) sCronetEngine).addSamplingSetting(r0);
        return;
    L10:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setZstdFuncAddr(long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setZstdFuncAddr(r19, r21, r23, r25, r27, r29, r31, r33);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void startThrottle(String[] r1, int r2, long r3) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).startThrottle(r1, r2, r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void stopThrottle(String[] r1, int r2) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).stopThrottle(r1, r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void triggerGetDomain(boolean r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).triggerGetDomain(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void triggerSwitchingToCellular() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).triggerWiFiToCellularByThirdParty();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryCreateCronetEngine(Context r19, boolean r20, boolean r21, boolean r22, boolean r23, String r24, Executor r25, boolean r26, ICronetAppProvider r27) {
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L173:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L168;
        Log.w(TAG, "CronetClient tryCreateCronetEngine");     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().m = System.currentTimeMillis();     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().n = System.nanoTime();     // Catch: Throwable -> L173
        if (r26 == true) goto L17;
        ICronetClient.ICronetBootFailureCheckerProvider r0 = sCronetBootFailureCheckerProvider;     // Catch: Throwable -> L173
        if (r0 == null) goto L17;
        if (r0.isCronetBootFailureExpected() == true) goto L17;
        Log.w(TAG, "isCronetBootFailureExpected return false.");     // Catch: Throwable -> L173
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L173
    L17:
        d.b.h.a.a.c.k().o = System.nanoTime();     // Catch: Throwable -> L173
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r1 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L173
        if (r1 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        d.b.h.a.a.c.k().p = System.nanoTime();     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().q = System.nanoTime();     // Catch: Throwable -> L173
        boolean r7 = c.W().B();     // Catch: Throwable -> L173
        if (r7 == false) goto L26;
        com.bytedance.frameworks.baselib.network.http.cronet.b r9 = r27.getAppInfoSubset();     // Catch: Throwable -> L173
    L27:
        d.b.h.a.a.c.k().r = System.nanoTime();     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().s = d.b.h.a.a.c.k().r;     // Catch: Throwable -> L173
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r10 = convertToCronetThreadConfigInfoList(getThreadConfigInfoList(), r6);     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().t = System.nanoTime();     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().u = d.b.h.a.a.c.k().t;     // Catch: Throwable -> L173
        TTThreadConfigInfoProvider.Callback r11 = convertToCronetThreadConfigCallback(getThreadConfigCallbackImpl());     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().v = System.nanoTime();     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().w = d.b.h.a.a.c.k().v;     // Catch: Throwable -> L173
        sAppID = Integer.parseInt(r27.getAppId());     // Catch: Exception -> L177 Throwable -> L173
    L29:
        TTSamplingSettingProvider.TTSlaSamplingSetting r12 = convertToCronetSlaSamplingSetting(d.b.h.a.a.k.d.a(getSlaSamplingSetting(), sAppID));     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().x = System.nanoTime();     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().y = d.b.h.a.a.c.k().x;     // Catch: Throwable -> L173
        ExperimentalCronetEngine.Builder r13 = new ExperimentalCronetEngine.Builder(r19, r7).enableQuic(r20).enableHttp2(r21).enableSdch(r22).enableHttpDns(r23).listenAppStateIndependently(getListenAppStateIndependently()).enableNetworkQualityEstimator(true);     // Catch: Throwable -> L173
        if (d.a().loggerDebug() == false) goto L32;
        r13.enableVerboseLog();     // Catch: Throwable -> L173
    L32:
        com.bytedance.frameworks.baselib.network.http.cronet.b r16 = r9;
        r13.setTTNetInitStart(Math.min(d.b.h.a.a.c.k().f13229e, d.b.h.a.a.c.k().n));     // Catch: Throwable -> L173
        detectCronetColdStartCrash(r19, r13);     // Catch: Throwable -> L173
        String r8 = "";
        r8 = r19.getCacheDir().getPath() + "/";     // Catch: Throwable -> L40
        r13.setStoragePath(r8 + TTNET_CACHE_DIR);     // Catch: Throwable -> L40
        boolean r17 = r6;
        r13.enableHttpCache(3, getMaxHttpDiskCacheSize());     // Catch: Throwable -> L38
    L44:
        if (sNetworkThreadPriority >= (-20)) goto L46;
    L48:
        int r2 = getAppSecurityLevel();     // Catch: Throwable -> L173
        if (r2 <= 0) goto L52;
        r13.setAppSecurityLevel(r2);     // Catch: Throwable -> L173
    L52:
        if (c.W().Y() == false) goto L54;
        boolean r5 = true;
        r13.enableBrotli(true);     // Catch: Throwable -> L173
    L56:
        if (c.W().a0() == false) goto L59;
        r13.enableQuic(r5);     // Catch: Throwable -> L173
    L59:
        if (c.W().Z() == false) goto L61;
        r13.enableHttp2(r5);     // Catch: Throwable -> L173
    L61:
        TTAppSecurityManager.getInstance().setSystemApiSandbox(f.a());     // Catch: Throwable -> L173
        r13.setAppInfoProvider(a.b(r19));     // Catch: Throwable -> L173
        r13.setEventListener(e.a());     // Catch: Throwable -> L173
        r13.setIsMainProcess(h.h(r19));     // Catch: Throwable -> L173
        r13.setProcessName(h.a(r19));     // Catch: Throwable -> L173
        if (h.h(r19) == false) goto L64;
        r13.setAppMonitorProvider(b.a());     // Catch: Throwable -> L173
        e.a().c(true);     // Catch: Throwable -> L173
    L64:
        if (r7 == false) goto L66;
        r13.setTTAppInfoColdStartSubset(convertToCronetAppInfo(r16));     // Catch: Throwable -> L173
    L66:
        r13.setOptInit(r7);     // Catch: Throwable -> L173
        r13.setOptNqeInit(r27.getOptNqeDefault(), r27.getOptNqePersist());     // Catch: Throwable -> L173
        r13.setThreadConfigInfoList(r10);     // Catch: Throwable -> L173
        r13.setThreadConfigCallbackImpl(r11);     // Catch: Throwable -> L173
        r13.setLazyInitIPC(r27.getLazyInitCronetIPC());     // Catch: Throwable -> L173
        if (TextUtils.isEmpty(r24) == true) goto L69;
        r13.setUserAgent(r24 + " cronet/" + TTNetVersion.VERSION);     // Catch: Throwable -> L173
    L69:
        String r3 = getDomainConfigByRegion();     // Catch: Throwable -> L173
        if (TextUtils.isEmpty(r3) == false) goto L73;
        r3 = c.W().q();     // Catch: Throwable -> L173
    L73:
        if (TextUtils.isEmpty(r3) == true) goto L75;
        r13.setGetDomainDefaultJSON(r3);     // Catch: Throwable -> L173
    L75:
        ArrayList<byte[]> r4 = c.W().A();     // Catch: Throwable -> L173
        if (r4 != null) goto L78;
    L80:
        Map<String[], Pair<byte[], byte[]>> r14 = c.W().j();     // Catch: Throwable -> L173
        if (r14 != null) goto L83;
    L85:
        Map<String, Pair<Integer, Integer>> r15 = c.W().C();     // Catch: Throwable -> L173
        if (r15 == null) goto L94;
        if (r15.isEmpty() == true) goto L94;
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r18 = r15.entrySet().iterator();     // Catch: Throwable -> L173
    L91:
        if (r18.hasNext() == false) goto L94;
        Map.Entry<String, Pair<Integer, Integer>> r28 = r18.next();     // Catch: Throwable -> L173
        r13.addQuicHint(r28.getKey(), ((Integer) r28.getValue().first).intValue(), ((Integer) r28.getValue().second).intValue());     // Catch: Throwable -> L173
    L94:
        if (c.W().b0() == false) goto L96;
        r13.setLibraryLoader(new AnonymousClass3(this));     // Catch: Throwable -> L173
    L96:
        String r29 = c.W().k();     // Catch: Throwable -> L173
        if (TextUtils.isEmpty(r29) == true) goto L101;
        String r30 = File.separator;     // Catch: Throwable -> L173
        String r31 = r29.substring(r29.lastIndexOf(r30) + 1);     // Catch: Throwable -> L173
        String r32 = r19.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L173
        if (com.bytedance.common.utility.n.a.a(r29, r32, r31) == false) goto L101;
        r13.setCronetSoPath(r32 + r30 + r31);     // Catch: Throwable -> L173
    L101:
        boolean r33 = c.W().X();     // Catch: Throwable -> L173
        if (r33 == false) goto L104;
        r13.enableBoeProxy(true);     // Catch: Throwable -> L173
    L104:
        if (r33 == true) goto L116;
        String r34 = d.b.h.a.a.h.s.c.d(r19, TTNET_CONFIG_FILE);     // Catch: Throwable -> L173
        if (TextUtils.isEmpty(r34) == true) goto L116;
        JSONObject r35 = new JSONObject(r34);     // Catch: Throwable -> L114
        String r36 = r35.optString("ttnet_proxy", "");     // Catch: Throwable -> L114
        if (TextUtils.isEmpty(r36) == true) goto L110;
        r13.setProxyConfig(r36);     // Catch: Throwable -> L114
    L110:
        r33 = r35.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L114
        if (r33 == false) goto L116;
        r13.enableBoeProxy(true);     // Catch: Throwable -> L114
    L114:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L173
    L116:
        if (r33 == true) goto L120;
        r33 = d.b.h.a.a.h.s.c.f(r19);     // Catch: Throwable -> L173
        if (r33 == false) goto L120;
        r13.enableBoeProxy(true);     // Catch: Throwable -> L173
    L120:
        if (r33 == false) goto L127;
        String r37 = c.W().g();     // Catch: Throwable -> L173
        if (TextUtils.isEmpty(r37) == true) goto L124;
        r13.setBypassBOEJSON(r37);     // Catch: Throwable -> L173
    L124:
        String r38 = getProxyConfig(r8);     // Catch: Throwable -> L173
        if (TextUtils.isEmpty(r38) == true) goto L127;
        Log.e(TAG, "set proxy config: " + r38);     // Catch: Throwable -> L173
        r13.setProxyConfig(r38);     // Catch: Throwable -> L173
    L127:
        String r39 = c.W().I();     // Catch: Throwable -> L173
        if (TextUtils.isEmpty(r39) == true) goto L186;
        r13.setStoreIdcRuleJSON(r39);     // Catch: Throwable -> L173
    L186:
        long r40 = getALogFuncAddr();     // Catch: Exception -> L134 Throwable -> L173
        if (r40 == 0) goto L138;
        Log.e(TAG, "set alog address: " + r40);     // Catch: Exception -> L134 Throwable -> L173
        r13.setALogFuncAddr(r40);     // Catch: Exception -> L134 Throwable -> L173
    L138:
        if (Build.VERSION.SDK_INT < 18) goto L188;
    L143:
        if (r12 == null) goto L145;
        r13.setSlaSamplingSetting(r12);     // Catch: Throwable -> L173
    L145:
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r41 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L173
        if (r41 != null) goto L148;
        String r42 = null;
    L149:
        r13.setStackInfo(r17, r42);     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().z = System.nanoTime();     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().A = d.b.h.a.a.c.k().z;     // Catch: Throwable -> L173
        sCronetEngine = r13.build();     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().B = System.nanoTime();     // Catch: Throwable -> L173
        if (d.a().loggerDebug() == false) goto L152;
        Logger.setLogLevel(2);     // Catch: Throwable -> L173
    L154:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L168;
        ExperimentalCronetEngine r43 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L173
        long r44 = getALogFuncAddr();     // Catch: Throwable -> L165
        if (r44 == 0) goto L159;
        Log.e(TAG, "ensure setting alog address: " + r44);     // Catch: Throwable -> L165
        r43.setAlogFuncAddr(r44);     // Catch: Throwable -> L165
    L159:
        int r45 = com.bytedance.frameworks.baselib.network.http.cronet.a.a();     // Catch: Throwable -> L165
        if (r45 < 0) goto L163;
        if (r45 > 2) goto L163;
        r43.setAppStartUpState(r45);     // Catch: Throwable -> L165
    L163:
        d.b.h.a.a.c.k().i(r19, r43.getOpaqueFuncAddress());     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L173
        goto L168
    L152:
        Logger.setLogLevel(4);     // Catch: Throwable -> L173
        goto L154
    L148:
        r42 = r41.getThreadStackInitReason();     // Catch: Throwable -> L173
        goto L149
    L188:
        System.loadLibrary(CRYPTO_LIBRARY_NAME);     // Catch: Throwable -> L141
        System.loadLibrary(BORINGSSL_LIBRARY_NAME);     // Catch: Throwable -> L141
    L141:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L173
    L134:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L173
        goto L138
    L83:
        if (r14.isEmpty() == true) goto L85;
        r13.setClientOpaqueData(r14);     // Catch: Throwable -> L173
        goto L85
    L78:
        if (r4.isEmpty() == true) goto L80;
        r13.setOpaqueData(r4);     // Catch: Throwable -> L173
        goto L80
    L54:
        r5 = true;
        goto L56
    L46:
        if (sNetworkThreadPriority > 19) goto L48;
        r13.setThreadPriority(sNetworkThreadPriority);     // Catch: Throwable -> L173
    L38:
        th = th;
    L42:
        Log.w(TAG, "ExperimentalCronetEngine.Builder enable HTTP Cache failed.");     // Catch: Throwable -> L173
        th.printStackTrace();     // Catch: Throwable -> L173
        r13.enableHttpCache(0, 0);     // Catch: Throwable -> L173
    L40:
        th = th;
        r17 = r6;
        goto L42
    L26:
        r9 = null;
        goto L27
    L20:
        if (r1.isCronetThreadStackOptFailureExpected() == false) goto L22;
        r6 = true;
    L168:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L170;
        ExperimentalCronetEngine r46 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L173
        tryCreateRequestFinishedInfoListener(r25);     // Catch: Throwable -> L173
        r46.addRequestFinishedListener(sRequestFinishedInfoListener);     // Catch: Throwable -> L173
    L170:
        d.b.r.k0.f.p(new AnonymousClass4(this));     // Catch: Throwable -> L173
        d.b.h.a.a.c.k().E = System.nanoTime();     // Catch: Throwable -> L173
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L173
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryStartNetDetect(String[] r1, int r2, int r3) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).tryStartNetDetect(r1, r2, r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void ttDnsResolve(String r1, int r2, String r3, Map<String, String> r4) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).ttDnsResolve(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public l ttUrlDispatch(String r8, int r9, boolean r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L11;
        Map<String, String> r7 = ((ExperimentalCronetEngine) sCronetEngine).ttUrlDispatch(r8, r9, r10);
        String r2 = r7.get(URLDispatch.KEY_FINAL_URL);
        if (TextUtils.isEmpty(r2) == true) goto L9;
        new URL(r2).toURI();
        return new l(r8, r2, r7.get(URLDispatch.KEY_EPOCH), r7.get(URLDispatch.KEY_ETAG), l.a.f4751f, r7.get(URLDispatch.KEY_TTNET_ORIGIN_HOST));
    L9:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L11:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }
}
