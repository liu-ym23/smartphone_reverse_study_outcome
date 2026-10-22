package com.bytedance.ttnet;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.e.j;
import com.bytedance.frameworks.baselib.network.http.cronet.e.l;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.j.k;
import d.b.h.a.a.h.o.b.s;
import d.b.h.a.a.h.o.b.z.m;
import d.b.r.c0;
import d.b.r.x;
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
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
    private static volatile f env = null;
    private static volatile boolean sApiHttpInterceptEnabled = false;
    private static volatile int sAppSecurityLevel = 0;
    private static volatile String sClientIPString = null;
    private static volatile boolean sCookieLogReportEnabled = false;
    private static long sCookieManagerInitStartTime = 0;
    public static ICronetAppProvider sCronetProvider = null;
    private static volatile int sDelayTime = 10;
    public static Map<String, String> sGetDomainRegionMap;
    private static com.bytedance.ttnet.e sITTNetDepend;
    private static volatile CountDownLatch sLatchInitCompleted;
    public static d.b.h.a.a.a sLifeCycleMonitor;
    private static volatile boolean sListenAppStateIndependently;
    private static volatile boolean sMainThreadInitCookieEnabled;
    private static volatile long sMaxHttpDiskCacheSize;
    private static volatile boolean sNotifiedColdStartFinsish;
    private static volatile List<String> sPublicIPv4List;
    private static volatile List<String> sPublicIPv6List;
    public static JSONObject sSlaSamplingSettingObject;
    private static volatile boolean sStateDelayNewStrategyEnabled;
    private static com.bytedance.ttnet.f sSystemApiSandbox;
    private static h sTTNetThreadConfigInfoManager;

    class a extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Context f6277k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f6278l;

        a(String r1, Context r2, boolean r3) {
            this.f6277k = r2;
            this.f6278l = r3;
            super(r1);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            Logger.debug();
            if (TTNetInit.access$100() == false) goto L5;
            d.b.r.l0.b r0 = com.bytedance.ttnet.p.i.f();
        L6:
            c0.y(r0);
            com.bytedance.ttnet.j.a.s(this.f6277k).H();
            com.bytedance.ttnet.j.a.s(this.f6277k).J(com.bytedance.ttnet.r.c.d.f6605j, true);
            TTNetInit.access$200(this.f6277k, this.f6278l, true);
            return;
        L5:
            r0 = k.l();
            goto L6
        }
    }

    class b extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Context f6279k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f6280l;
        final /* synthetic */ boolean m;

        b(String r1, Context r2, boolean r3, boolean r4) {
            this.f6279k = r2;
            this.f6280l = r3;
            this.m = r4;
            super(r1);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            com.bytedance.ttnet.j.a.s(this.f6279k).H();
            com.bytedance.ttnet.j.a.s(this.f6279k).J(com.bytedance.ttnet.r.c.d.f6605j, true);
            if (this.f6280l == false) goto L5;
            TTNetInit.access$200(this.f6279k, this.m, false);
            return;
        L5:
            d.b.h.a.a.h.g.M(true);
            TTNetInit.access$300();
        }
    }

    class c implements com.bytedance.ttnet.s.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6281a;

        c(Context r1) {
            this.f6281a = r1;
        }

        @Override // com.bytedance.ttnet.s.c.b
        public void a(String r3, String r4, int r5, boolean r6, JSONObject r7) {
            if (r6 == false) goto L4;
            int r8 = 1;
        L8:
            JSONObject r0 = new JSONObject();     // Catch: Throwable -> L7
            r0.put(WsConstants.KEY_CONNECTION_URL, r4);     // Catch: Throwable -> L7
            r0.put("value", r5);     // Catch: Throwable -> L7
            r0.put("ext_value", r8);     // Catch: Throwable -> L7
            r0.put("extraObject", r7);     // Catch: Throwable -> L7
            TTNetInit.getTTNetDepend().d(this.f6281a, "set_cookie", r3, r0);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L4:
            r8 = 0;
            goto L8
        }

        @Override // com.bytedance.ttnet.s.c.b
        public void b(String r1, String r2, String r3, com.bytedance.ttnet.m.b r4) {
        }
    }

    class d implements d.b.h.a.a.h.m.k.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6282a;

        d(Context r1) {
            this.f6282a = r1;
        }

        @Override // d.b.h.a.a.h.m.k.b
        public boolean a() {
            return TTNetInit.cookieLogReportEnabled();
        }

        @Override // d.b.h.a.a.h.m.k.b
        public void b(String r2, String r3, JSONObject r4) {
            if (TTNetInit.cookieLogReportEnabled() == false) goto L6;
            TTNetInit.getTTNetDepend().d(this.f6282a, r2, r3, r4);
            return;
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f6283f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f6284g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f6285h;

        e(Context r1, boolean r2, boolean r3) {
            this.f6283f = r1;
            this.f6284g = r2;
            this.f6285h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTNetInit.access$200(this.f6283f, this.f6284g, this.f6285h);
        }
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f6286f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f6287g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ f[] f6288h = null;

        static {
            f r0 = new f("DEBUG", 0);
            f6286f = r0;
            f r1 = new f("RELEASE", 1);
            f6287g = r1;
            f6288h = new f[]{r0, r1};
        }

        private f(String r1, int r2) {
            super(r1, r2);
        }

        public static f valueOf(String r1) {
            return (f) Enum.valueOf(f.class, r1);
        }

        public static f[] values() {
            return (f[]) f6288h.clone();
        }
    }

    static {
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = false;
        sCookieLogReportEnabled = false;
        sListenAppStateIndependently = false;
        sStateDelayNewStrategyEnabled = false;
        sMainThreadInitCookieEnabled = true;
        sMaxHttpDiskCacheSize = 67108864;
        sAppSecurityLevel = 0;
        sLifeCycleMonitor = new d.b.h.a.a.a();
        TTALog.init();
        env = f.f6287g;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
        sCookieManagerInitStartTime = 0;
    }

    public TTNetInit() {
    }

    private static void CookieInitFailedReport(Context r3, String r4) {
        JSONObject r1 = new JSONObject();
        r1.put("init", "failed");     // Catch: JSONException -> L5
        r1.put("exception", r4);     // Catch: JSONException -> L5
    L7:
        getTTNetDepend().d(r3, "TTNET-COOKIE", "init", r1);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences INVOKEVIRTUAL_com_bytedance_ttnet_TTNetInit_com_obric_matrix_SPLancet_getSharedPreferences2(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static void OnAppActivitySuspend() {
        if (getCronetHttpClient(d.b.h.a.a.c.b.o) == null) goto L9;
        d.b.h.a.a.h.a.c();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void OnAppActiviyResume() {
        if (getCronetHttpClient(d.b.h.a.a.c.b.o) == null) goto L9;
        d.b.h.a.a.h.a.d();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static com.bytedance.ttnet.n.c TTDnsResolve(String r1, int r2) {
        return TTDnsResolve(r1, r2, null);
    }

    public static com.bytedance.ttnet.n.c TTDnsResolve(String r1, int r2, Map<String, String> r3) {
        if (d.b.h.a.a.c.l() == false) goto L7;
        return com.bytedance.ttnet.n.a.c().b(r1, r2, r3);
    L7:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static /* synthetic */ boolean access$100() {
        return sStateDelayNewStrategyEnabled;
    }

    static /* synthetic */ void access$200(Context r0, boolean r1, boolean r2) {
        tryInitCookieManager(r0, r1, r2);
    }

    static /* synthetic */ void access$300() {
        setCookieInitCompleted();
    }

    public static void addClientOpaqueData(Context r8, String[] r9, byte[] r10, byte[] r11) {
        j.w(r8).f(r9, r10, r11, 0, 0);
    }

    public static void addClientOpaqueData(Context r8, String[] r9, byte[] r10, byte[] r11, long r12, long r14) {
        j.w(r8).f(r9, r10, r11, r12, r14);
    }

    public static boolean apiHttpInterceptEnabled() {
        return sApiHttpInterceptEnabled;
    }

    public static void clearClientOpaqueData(Context r0) {
        j.w(r0).h();
    }

    private static void clearSharedPreferencesFile(Context r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        INVOKEVIRTUAL_com_bytedance_ttnet_TTNetInit_com_obric_matrix_SPLancet_getSharedPreferences2(r1, r2, 0).edit().clear().apply();
        return;
    }

    public static void clearTNCFileBeforeStart(Context r3) {
        if (r3 == null) goto L12;
        File r0 = new File(r3.getFilesDir(), "server.json");     // Catch: Throwable -> L13
        if (r0.exists() == false) goto L6;
        r0.delete();     // Catch: Throwable -> L13
    L6:
        File r1 = new File(r3.getFilesDir(), "tt_net_config.config");     // Catch: Throwable -> L13
        if (r1.exists() == false) goto L9;
        r1.delete();     // Catch: Throwable -> L13
    L9:
        clearSharedPreferencesFile(r3, com.bytedance.ttnet.j.a.t());
        clearSharedPreferencesFile(r3, "ttnet_tnc_config");
        clearSharedPreferencesFile(r3, d.b.h.a.a.h.r.b.l());
        return;
    L12:
        throw new IllegalArgumentException("context is null");
    }

    private static l convertReflectException(String r2, Exception r3) {
        Throwable r4 = r3.getCause();
        if ((r4 instanceof InvocationTargetException) == false) goto L5;
        Throwable r5 = r4.getCause();
        if (r5 == null) goto L9;
        String r0 = r5.getMessage();
    L11:
        if ((r5 instanceof SocketTimeoutException) == false) goto L17;
        if ("ttnet".equals(r0) == false) goto L17;
        return new l(r2, l.a.f4754i);
    L17:
        if ((r5 instanceof UnsupportedOperationException) == false) goto L23;
        if ("CronetEngine has not been initialized.".equals(r0) == false) goto L23;
        return new l(r2, l.a.f4753h);
    L23:
        if ((r5 instanceof IllegalStateException) == false) goto L29;
        if ("Engine is shut down.".equals(r0) == false) goto L29;
        return new l(r2, l.a.f4753h);
    L29:
        return new l(r2, l.a.m);
    L9:
        r0 = "";
        goto L11
    L5:
        return new l(r2, l.a.m);
    }

    public static boolean cookieLogReportEnabled() {
        return sCookieLogReportEnabled;
    }

    private static void countDownInitCompletedLatch() {
        if (sLatchInitCompleted.getCount() <= 0) goto L9;
        sLatchInitCompleted.countDown();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    @Deprecated
    public static List<InetAddress> dnsLookup(String r3) {
        if (d.b.h.a.a.c.l() == false) goto L24;
        com.bytedance.ttnet.n.c r0 = TTDnsResolve(r3, 0);
        if (r0.f6493a != 0) goto L22;
        List<String> r1 = r0.f6494b;
        if (r1 == null) goto L22;
        if (r1.isEmpty() == true) goto L22;
        ArrayList r2 = new ArrayList();
        Iterator<String> r4 = r0.f6494b.iterator();
    L12:
        if (r4.hasNext() == false) goto L17;
        byte[] r5 = InetAddress.getByName(r4.next()).getAddress();
        if (r5 == null) goto L12;
        r2.add(InetAddress.getByAddress(r3, r5));
        goto L12
    L17:
        if (r2.isEmpty() == true) goto L20;
        return r2;
    L20:
        throw new UnknownHostException(r3);
    L22:
        throw new UnknownHostException(r3);
    L24:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    @Deprecated
    public static void doCommand(Context r0, String r1) {
    }

    public static void enableApiHttpIntercept(boolean r0) {
        sApiHttpInterceptEnabled = r0;
    }

    public static void enableCookieLogReport(boolean r0) {
        sCookieLogReportEnabled = r0;
    }

    public static void enableProceedWithoutHook(boolean r0) {
        d.b.r.j0.b.f(r0);
    }

    public static void enableSsCallUseOkioReadForNoneStream(boolean r0) {
        d.b.h.a.a.h.m.b.P(r0);
    }

    public static void enableSsCallUseZeroCopyReadForNoneStream(boolean r0) {
        com.bytedance.frameworks.baselib.network.http.cronet.e.c.k0(r0);
    }

    public static void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        if (r8 == true) goto L4;
    L15:
        j r1 = getCronetHttpClient(d.b.h.a.a.c.b.f13242l);     // Catch: Throwable -> L14
        if (r1 == null) goto L19;
        r1.i(r8, r9, r10, r11, r12, r13);     // Catch: Throwable -> L14
        return;
    L19:
        return;
    L20:
        return;
    L4:
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L15;
    }

    private static void feedBackCronetInitFailedLog(int r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("fallback", r2);     // Catch: JSONException -> L13
        r0.put("exception", r3);     // Catch: JSONException -> L13
        r0.put("model", Build.MODEL);     // Catch: JSONException -> L13
        String r4 = "";
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        r4 = Build.CPU_ABI;     // Catch: JSONException -> L13
    L11:
        r0.put("abis", r4);     // Catch: JSONException -> L13
        getTTNetDepend().c("cronet_failed", r0);     // Catch: JSONException -> L13
        return;
    L6:
        String[] r5 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L13
        if (r5 == null) goto L11;
        if (r5.length <= 0) goto L11;
        r4 = Arrays.asList(r5).toString();     // Catch: JSONException -> L13
    }

    public static void forceInitCronetKernel() {
        if (d.b.h.a.a.c.k().f13225a != d.b.h.a.a.c.b.f13237g) goto L5;
        d.b.h.a.a.c r0 = d.b.h.a.a.c.k();
        r0.f13225a = d.b.h.a.a.c.b.f13240j;
    L5:
        j.w(getTTNetDepend().getContext()).a0(false, false, false, com.bytedance.ttnet.j.a.s(getTTNetDepend().getContext()).h(), true, sCronetProvider);
    }

    @Deprecated
    public static long getALogFuncAddr() {
        return TTALog.getALogFuncAddr();
    }

    public static int getAppSecurityLevel() {
        return sAppSecurityLevel;
    }

    public static String getClientIpString() {
        return sClientIPString;
    }

    private static j getCronetHttpClient(d.b.h.a.a.c.b r8) {
        if (d.b.h.a.a.c.k().f13225a != d.b.h.a.a.c.b.f13237g) goto L6;
        d.b.h.a.a.c.k().f13225a = r8;
    L6:
        if (com.bytedance.ttnet.d.c() == false) goto L9;
        j r9 = j.w(getTTNetDepend().getContext());
        r9.a0(false, true, false, com.bytedance.ttnet.j.a.s(getTTNetDepend().getContext()).h(), false, sCronetProvider);
        sSlaSamplingSettingObject = null;
        return r9;
    L9:
        return null;
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static int getEffectiveConnectionType() {
        return j.w(getTTNetDepend().getContext()).p();
    L4:
        return 0;
    }

    public static f getEnv() {
        return env;
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

    public static Map<String, com.bytedance.frameworks.baselib.network.http.cronet.e.h> getGroupRttEstimates() {
        return j.w(getTTNetDepend().getContext()).r();
    }

    public static void getInitCompletedLatch() {
        sLatchInitCompleted.await(5, TimeUnit.SECONDS);     // Catch: Exception -> L4
        return;
    }

    public static boolean getListenAppStateIndependently() {
        return sListenAppStateIndependently;
    }

    public static void getMappingRequestState(String r1) {
        j.w(getTTNetDepend().getContext()).s(r1);     // Catch: Throwable -> L4
        return;
    }

    public static long getMaxHttpDiskCacheSize() {
        return sMaxHttpDiskCacheSize;
    }

    public static com.bytedance.frameworks.baselib.network.http.cronet.e.h getNetworkQuality() {
        return j.w(getTTNetDepend().getContext()).t();
    }

    public static com.bytedance.frameworks.baselib.network.http.cronet.e.i getPacketLossRateMetrics(int r1) {
        return j.w(getTTNetDepend().getContext()).u(r1);
    }

    public static List<String> getPublicIPv4List() {
        return sPublicIPv4List;
    }

    public static List<String> getPublicIPv6List() {
        return sPublicIPv6List;
    }

    public static JSONObject getSlaSamplingSetting() {
        return sSlaSamplingSettingObject;
    }

    public static boolean getStateDelayNewStrategyEnabled() {
        return sStateDelayNewStrategyEnabled;
    }

    public static com.bytedance.ttnet.f getSystemApiSandbox() {
        return sSystemApiSandbox;
    }

    public static com.bytedance.ttnet.e getTTNetDepend() {
        com.bytedance.ttnet.e r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static com.bytedance.frameworks.baselib.network.http.cronet.c.a getThreadConfigCallbackImpl() {
        h r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public static List<com.bytedance.frameworks.baselib.network.http.cronet.c> getThreadConfigInfoList() {
        h r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public static void monitorLogSend(String r1, JSONObject r2) {
        com.bytedance.ttnet.e r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        r0.c(r1, r2);
        return;
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

    public static void onPublicIPsChanged(List<String> r0, List<String> r1) {
        sPublicIPv4List = r0;
        sPublicIPv6List = r1;
    }

    public static void preInitCronetKernel() {
        int r0 = -1;
    L7:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L11;
        r0 = 3;
    L11:
        String r2 = com.bytedance.ttnet.s.e.f(th);
        if (r2.length() <= 1024) goto L14;
        r2 = r2.substring(0, 1024);
    L14:
        feedBackCronetInitFailedLog(r0, r2);
        com.bytedance.ttnet.r.c.l().o();
        throw th;
    L4:
        if (getCronetHttpClient(d.b.h.a.a.c.b.f13239i) != null) goto L18;
        r0 = s.l();     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r0, "");     // Catch: Throwable -> L7
        return;
    }

    public static void preconnectUrl(String r1) {
        preconnectUrl(r1, null);
    }

    public static void preconnectUrl(String r1, Map<String, String> r2) {
        if (d.b.h.a.a.c.l() == false) goto L9;
        new URL(r1).toURI();     // Catch: Exception -> L6
        j.w(getTTNetDepend().getContext()).F(r1, r2);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw e;
    L9:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void removeClientOpaqueData(Context r0, String r1) {
        j.w(r0).G(r1);
    }

    public static void runInBackGround(Context r0, boolean r1) {
        j.w(r0).I(r1);
    }

    @Deprecated
    public static void setALogFuncAddr(long r0) {
    }

    public static void setAppSecurityLevel(int r0) {
        sAppSecurityLevel = r0;
    }

    public static void setBypassOfflineCheck(boolean r0) {
        j.L(r0);
    }

    public static void setCookieHandler(Context r9) {
        CookieHandler r0 = CookieHandler.getDefault();     // Catch: Throwable -> L23
        if (r0 == null) goto L9;
        if ((r0 instanceof d.b.h.a.a.h.m.k) == false) goto L9;
        d.b.h.a.a.h.g.M(true);     // Catch: Throwable -> L23
        setCookieInitCompleted();     // Catch: Throwable -> L23
        return;
    L9:
        if (sCookieManagerInitStartTime > 0) goto L13;
        d.b.h.a.a.h.g.M(true);     // Catch: Throwable -> L23
        setCookieInitCompleted();     // Catch: Throwable -> L23
        return;
    L13:
        if (d.b.h.a.a.c.k().f13233i != 0) goto L15;
        d.b.h.a.a.c r1 = d.b.h.a.a.c.k();     // Catch: Throwable -> L23
        r1.f13233i = System.nanoTime();     // Catch: Throwable -> L23
    L15:
        CookieManager r2 = null;
        r2 = CookieManager.getInstance();     // Catch: Throwable -> L18
    L17:
        CookieManager r6 = r2;
        CookieHandler.setDefault(new d.b.h.a.a.h.m.k(r9, sDelayTime, r6, getTTNetDepend().m(), new d(r9)));     // Catch: Throwable -> L23
        d.b.h.a.a.h.g.M(true);     // Catch: Throwable -> L23
        setCookieInitCompleted();     // Catch: Throwable -> L23
        d.b.h.a.a.c r3 = d.b.h.a.a.c.k();     // Catch: Throwable -> L23
        r3.f13234j = System.nanoTime();     // Catch: Throwable -> L23
        return;
    L18:
        th = move-exception;
        sDelayTime = 0;     // Catch: Throwable -> L23
        CookieInitFailedReport(r9, th.getMessage());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CookieInitFailedReport(r9, th.getMessage());
    }

    private static void setCookieInitCompleted() {
        j r0 = getCronetHttpClient(d.b.h.a.a.c.b.n);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.M();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void setCronetDepend(ICronetAppProvider r1) {
        if (r1 == null) goto L6;
        sCronetProvider = r1;
        com.bytedance.ttnet.r.c.t(r1);
        com.bytedance.ttnet.o.a.d().e(r1);
        j.N(r1);
        s.s(com.bytedance.ttnet.o.a.d());
        return;
    L6:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    public static void setDelayTime(int r0) {
        sDelayTime = r0;
    }

    @Deprecated
    public static void setEnableURLDispatcher(boolean r0) {
    }

    public static void setEnv(f r0) {
        env = r0;
    }

    public static void setFirstRequestWaitTime(long r0) {
    }

    public static void setGetDomainRegionMap(Map<String, String> r1) {
        if (r1 == null) goto L6;
        sGetDomainRegionMap = r1;
        return;
    L6:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    @Deprecated
    public static void setHostResolverRulesForTesting(String r1) {
        j r0 = getCronetHttpClient(d.b.h.a.a.c.b.f13241k);
        if (r0 == null) goto L6;
        r0.S(r1);
        return;
    }

    public static void setHttpDnsForTesting(boolean r0, boolean r1, boolean r2) {
    }

    public static void setListenAppStateIndependently(boolean r0) {
        sListenAppStateIndependently = r0;
    }

    public static void setMainThreadInitCookieEnabled(boolean r0) {
        sMainThreadInitCookieEnabled = r0;
    }

    public static void setMaxHttpDiskCacheSize(long r2) {
        if (r2 <= 0) goto L6;
        sMaxHttpDiskCacheSize = r2;
        return;
    }

    public static void setProcessFlag(int r0) {
        d.b.h.a.a.h.s.h.j(r0);
    }

    public static void setProxy(String r1) {
        if (d.b.h.a.a.c.l() == false) goto L5;
        j.w(getTTNetDepend().getContext()).T(r1);
        return;
    L5:
        s.t(getTTNetDepend().getContext());
        s.x(r1);
    }

    public static void setSlaSamplingSetting(Context r0, JSONObject r1) {
        j.w(r0).U(r1);     // Catch: Exception -> L4
        return;
    L4:
        sSlaSamplingSettingObject = r1;
    }

    public static void setStateDelayNewStrategyEnabled(boolean r0) {
        sStateDelayNewStrategyEnabled = r0;
    }

    public static void setSystemApiSandbox(com.bytedance.ttnet.f r0) {
        sSystemApiSandbox = r0;
    }

    public static void setTTNetDepend(com.bytedance.ttnet.e r6) {
        sITTNetDepend = r6;
        Map<String, String> r0 = getTTNetDepend().j();
        if (TextUtils.isEmpty(r0.get(DOMAIN_HTTPDNS_KEY)) == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L19;
        Object r2 = sITTNetDepend;
        if ((r2 instanceof com.bytedance.ttnet.b) == true) goto L15;
    L17:
        com.bytedance.ttnet.m.b.d();
        d.b.h.a.a.h.s.c.n(r0.get(DOMAIN_BOE_KEY));
        d.b.h.a.a.h.s.c.m(r0.get(DOMAIN_BOE_HTTPS_KEY));
        com.bytedance.ttnet.o.a.d().f(r6);
        return;
    L15:
        if (((com.bytedance.ttnet.b) r2).d() == true) goto L17;
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

    public static void setTTNetThreadConfigInfoManager(h r0) {
    }

    public static void setZstdFuncAddr(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) {
        j r1 = getCronetHttpClient(d.b.h.a.a.c.b.m);
        if (r1 == null) goto L6;
        Logger.debug();
        r1.V(r18, r20, r22, r24, r26, r28, r30, r32);
        return;
    }

    public static void trigerGetDomain(Context r1) {
        triggerGetDomain(r1, false);
    }

    public static void triggerGetDomain(Context r0, boolean r1) {
        j.w(r0).Y(r1);
    }

    private static void tryInitCookieManager(Context r5, boolean r6, boolean r7) {
        Logger.debug();
        sCookieManagerInitStartTime = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r6 == true) goto L6;
        d.b.h.a.a.h.g.M(true);     // Catch: Throwable -> L11
        setCookieInitCompleted();     // Catch: Throwable -> L11
    L28:
        ClientKeyManager.k().b(r7);
        return;
    L6:
        if (d.b.h.a.a.c.k().f13233i != 0) goto L8;
        d.b.h.a.a.c r1 = d.b.h.a.a.c.k();     // Catch: Throwable -> L11
        r1.f13233i = System.nanoTime();     // Catch: Throwable -> L11
    L8:
        CookieSyncManager.createInstance(r5);     // Catch: Throwable -> L11
        CookieManager.getInstance().setAcceptCookie(true);     // Catch: Throwable -> L11
        setCookieHandler(r5);     // Catch: Throwable -> L11
        Logger.debug();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (d.b.h.a.a.h.s.h.h(r5) == false) goto L28;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L28;
        if (sMainThreadInitCookieEnabled == false) goto L19;
        new Handler(Looper.getMainLooper()).post(new e(r5, r6, r7));
    L19:
        JSONObject r8 = new JSONObject();
        r8.put(WsConstants.KEY_CONNECTION_ERROR, th.getMessage());     // Catch: JSONException -> L22
    L24:
        com.bytedance.ttnet.e r2 = sITTNetDepend;
        if (r2 == null) goto L27;
        r2.c("async_init_cookie_manager_fail", r8);
    L27:
        CookieInitFailedReport(r5, th.getMessage());
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static void tryInitTTNet(Context r3, Application r4, d.b.h.a.a.h.g.d<com.bytedance.ttnet.m.b> r5, d.b.h.a.a.h.g.l<com.bytedance.ttnet.m.b> r6, d.b.h.a.a.h.g.h r7, boolean r8, boolean... r9) {
        d.b.h.a.a.c.k().f13228d = System.currentTimeMillis();
        d.b.h.a.a.c.k().f13229e = System.nanoTime();
        if (r3 == null) goto L35;
        com.bytedance.ttnet.j.g.a();
        com.bytedance.ttnet.l.a.b(r3);
        x.b(Logger.getLogLevel());
        d.b.h.a.a.h.g.H(r5);
        com.bytedance.ttnet.m.b.d();
        KevaBuilder.getInstance().setContext(r3);
        if (r9 != null) goto L7;
    L9:
        boolean r10 = false;
    L10:
        boolean r0 = d.b.h.a.a.h.s.h.h(r3);
        if (r0 == false) goto L13;
        new a("NetWork-AsyncInit", r3, r8).b();
    L20:
        g.c();
        com.bytedance.ttnet.r.c.l().u(r3, r0);
        d.b.h.a.a.h.o.b.z.l.m().s(r3);
        com.bytedance.ttnet.j.a.s(r3);
        d.b.h.a.a.c.k().j(r3);
        d.b.h.a.a.h.g.R(r6);
        countDownInitCompletedLatch();
        if (r0 == true) goto L25;
        d.b.h.a.a.c.k().f13226b = false;
    L23:
        d.b.h.a.a.c.k().f13232h = System.nanoTime();
        return;
    L25:
        d.b.h.a.a.h.g.K(r7);
        if (com.bytedance.ttnet.s.c.c() != null) goto L28;
        com.bytedance.ttnet.s.c.f(new c(r3));
    L28:
        sLifeCycleMonitor.c(d.b.h.a.a.j.e.f());
        if (r4 == null) goto L32;
        r4.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
    L32:
        if (com.bytedance.ttnet.d.c() == true) goto L23;
        notifyColdStartFinish();
        goto L23
    L13:
        if (r10 == false) goto L15;
    L18:
        boolean r11 = true;
    L19:
        new b("NetWork-AsyncInit-other", r3, r11, r8).b();
        goto L20
    L15:
        if (d.b.h.a.a.h.s.h.i(r3) == true) goto L18;
        r11 = false;
        goto L19
    L7:
        if (r9.length <= 0) goto L9;
        r10 = r9[0];
        goto L10
    L35:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void trySetDefaultUserAgent(String r0) {
        d.b.h.a.a.h.g.O(r0);
    }

    public static boolean tryStartTTNetDetect(String[] r2, int r3, int r4) {
        if (r2 != null) goto L5;
    L14:
        return false;
    L5:
        if (r2.length <= 0) goto L14;
        if (r3 <= 0) goto L14;
        if (r3 > 180) goto L14;
        if (r4 < 0) goto L14;
        j.w(getTTNetDepend().getContext()).c0(r2, r3, r4);     // Catch: Throwable -> L15
        return true;
    }

    public static l ttUrlDispatch(String r2) {
        return ttUrlDispatchInternal(r2, -1, true);
    }

    private static l ttUrlDispatchInternal(String r7, int r8, boolean r9) {
        if (com.bytedance.ttnet.j.a.s(getTTNetDepend().getContext()).i() == true) goto L11;
        d.b.h.a.a.h.o.b.z.e r10 = d.b.h.a.a.h.o.b.z.l.m().e(new m(r7, null, null));
        if (r10 == null) goto L9;
        return new l(r7, r10.f13664a, String.valueOf(d.b.h.a.a.h.o.b.z.l.m().f()), d.b.h.a.a.h.o.b.z.l.m().i(), l.a.f4751f, "");
    L9:
        throw new IllegalArgumentException(OKHTTP_DISPATCH_FAILED);
    L11:
        if (d.b.h.a.a.c.l() == false) goto L17;
        new URL(r7).toURI();     // Catch: Exception -> L14
        return j.f0(r7, r8, r9);
    L14:
        e = move-exception;
        throw e;
    L17:
        throw new IllegalStateException(TTNET_CRONET_NOT_INITIALIZED);
    }

    public static l ttUrlDispatchV2(String r1, int r2) {
        return ttUrlDispatchV2(r1, r2, true);
    }

    public static l ttUrlDispatchV2(String r1, int r2, boolean r3) {
        new URL(r1).toURI();     // Catch: Exception -> L37
        return ttUrlDispatchInternal(r1, r2, r3);
    L5:
        e = move-exception;
        String r4 = e.getMessage();
        if ((e instanceof com.bytedance.common.utility.reflect.a) == false) goto L11;
        return convertReflectException(r1, e);
    L11:
        if ((e instanceof IllegalArgumentException) == false) goto L17;
        if (OKHTTP_DISPATCH_FAILED.equals(r4) == false) goto L17;
        return new l(r1, l.a.f4757l);
    L17:
        if ((e instanceof IllegalStateException) == false) goto L23;
        if (TTNET_CRONET_NOT_INITIALIZED.equals(r4) == false) goto L23;
        return new l(r1, l.a.f4753h);
    L23:
        if ((e instanceof UnknownFormatConversionException) == false) goto L29;
        if (RETURN_WRONG_FORMAT.equals(r4) == false) goto L29;
        return new l(r1, l.a.f4756k);
    L29:
        if ((e instanceof URISyntaxException) == true) goto L36;
        if ((e instanceof MalformedURLException) == true) goto L36;
        return new l(r1, l.a.m);
    L36:
        return new l(r1, l.a.f4755j);
    L38:
        return new l(r1, l.a.f4752g);
    }

    @Deprecated
    public static boolean urlDispatchEnabled() {
        return true;
    }

    public static void useCustomizedCookieStoreName() {
        d.b.h.a.a.h.m.i.m();
    }
}
