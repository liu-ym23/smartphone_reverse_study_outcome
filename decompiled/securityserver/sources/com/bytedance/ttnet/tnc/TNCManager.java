package com.bytedance.ttnet.tnc;

import a.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3TncBridge;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3TTPSandBoxInterceptor;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.keva.KevaImpl;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.bytedance.ttnet.AbsOptionalTTNetDepend;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.bytedance.ttnet.http.GetDomainContext;
import com.bytedance.ttnet.http.HttpURLConnClient;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TNCManager implements Ok3TncBridge {
    private static final int MSG_UPDATE_REMOTE = 10000;
    private static final String TAG = "TNCManager";
    public static final String TNC_ABTEST_NAME = "ttnet_tnc_abtest";
    public static final String TNC_CONFIG_KEY_NAME = "data";
    public static final String TNC_CONFIG_STR = "tnc_config_str";
    public static final String TNC_ETAG_NAME = "ttnet_tnc_etag";
    public static final String TNC_IS_FULL_CONFIG = "is_full_config";
    private static final int TNC_PROBE_CMD_GET_DOMAIN = 10000;
    private static final int TNC_PROBE_CMD_TEST = 1000;
    private static final String TNC_PROBE_HEADER = "tt-idc-switch";
    private static final String TNC_PROBE_HEADER_SECEPTOR = "@";
    public static final String TNC_SP_NAME = "ttnet_tnc_config";
    private static String mGetDomainDefaultJson;
    private static TNCManager sInstance;
    private volatile boolean mColdStartFinish;
    private volatile boolean mConfigUpdateSuccess;
    private volatile long mConfigUpdateTime;
    private Context mContext;
    private AtomicBoolean mCronetFailedTncSent;
    Handler mHandler;
    private boolean mInited;
    private boolean mIsMainProcess;
    private long mLastDoUpdateTime;
    private volatile long mLastProbeGetTime;
    private volatile long mLastProbeSendTime;
    private HashMap<String, Integer> mReqErrApiMap;
    private HashMap<String, Integer> mReqErrIpMap;
    private int mReqErrorCnt;
    private HashMap<String, Integer> mReqToApiMap;
    private int mReqToCnt;
    private HashMap<String, Integer> mReqToIpMap;
    private volatile long mRequestStartTime;
    private volatile ITncSandBox mSandBox;
    private TNCConfigHandler mTNCConfigHandler;
    private TNCUpdateSource mTNCSource;
    private String mTncCanary;
    private String mTncConfigId;
    private volatile int mTncProbeCmd;
    private volatile long mTncProbeSuccessVersion;
    private volatile long mTncProbeVersion;
    OkHttp3TTPSandBoxInterceptor.ITncSandBox okTNCSandBox;

    public interface ITncSandBox {
        boolean isTncRequestProceed(String r1, String r2, List<Header> r3, String r4);

        boolean isTncResponseProceed(String r1, String r2, List<Header> r3, String r4);
    }

    public static final enum TNCUpdateSource extends Enum<TNCUpdateSource> {
        private static final /* synthetic */ TNCUpdateSource[] $VALUES = null;
        public static final TNCUpdateSource PORTRETRY = null;
        public static final TNCUpdateSource TTCACHE = null;
        public static final TNCUpdateSource TTCRONET = null;
        public static final TNCUpdateSource TTCRONETFAILED = null;
        public static final TNCUpdateSource TTERROR = null;
        public static final TNCUpdateSource TTHardCode = null;
        public static final TNCUpdateSource TTPOLL = null;
        public static final TNCUpdateSource TTREGION = null;
        public static final TNCUpdateSource TTRESUME = null;
        public static final TNCUpdateSource TTSERVER = null;
        public static final TNCUpdateSource TTTNC = null;
        public final int mValue;

        static {
            TNCUpdateSource r0 = new TNCUpdateSource("TTRESUME", 0, -2);
            TTRESUME = r0;
            TNCUpdateSource r1 = new TNCUpdateSource("TTHardCode", 1, -1);
            TTHardCode = r1;
            TNCUpdateSource r2 = new TNCUpdateSource("TTCACHE", 2, 0);
            TTCACHE = r2;
            TNCUpdateSource r3 = new TNCUpdateSource("TTSERVER", 3, 1);
            TTSERVER = r3;
            TNCUpdateSource r4 = new TNCUpdateSource("TTERROR", 4, 2);
            TTERROR = r4;
            TNCUpdateSource r5 = new TNCUpdateSource("TTPOLL", 5, 3);
            TTPOLL = r5;
            TNCUpdateSource r6 = new TNCUpdateSource("TTTNC", 6, 4);
            TTTNC = r6;
            TNCUpdateSource r7 = new TNCUpdateSource("PORTRETRY", 7, 7);
            PORTRETRY = r7;
            TNCUpdateSource r8 = new TNCUpdateSource("TTREGION", 8, 10);
            TTREGION = r8;
            TNCUpdateSource r9 = new TNCUpdateSource("TTCRONET", 9, 20);
            TTCRONET = r9;
            TNCUpdateSource r10 = new TNCUpdateSource("TTCRONETFAILED", 10, 30);
            TTCRONETFAILED = r10;
            $VALUES = new TNCUpdateSource[]{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        }

        private TNCUpdateSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.mValue = r3;
        }

        public static TNCUpdateSource valueOf(String r1) {
            return (TNCUpdateSource) Enum.valueOf(TNCUpdateSource.class, r1);
        }

        public static TNCUpdateSource[] values() {
            return (TNCUpdateSource[]) $VALUES.clone();
        }
    }

    private TNCManager() {
        this.mLastDoUpdateTime = 0;
        this.mLastProbeSendTime = 0;
        this.mLastProbeGetTime = 0;
        this.mTNCSource = TNCUpdateSource.TTCACHE;
        this.mConfigUpdateTime = 0;
        this.mColdStartFinish = false;
        this.mConfigUpdateSuccess = false;
        this.mCronetFailedTncSent = new AtomicBoolean(false);
        this.mInited = false;
        this.mTncProbeCmd = 0;
        this.mTncProbeVersion = 0;
        this.mTncProbeSuccessVersion = 0;
        this.mReqToCnt = 0;
        this.mReqToApiMap = new HashMap();
        this.mReqToIpMap = new HashMap();
        this.mReqErrorCnt = 0;
        this.mReqErrApiMap = new HashMap();
        this.mReqErrIpMap = new HashMap();
        this.mIsMainProcess = true;
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass2(this, r1);
        this.mSandBox = null;
        this.okTNCSandBox = new AnonymousClass3(this);
    }

    public static /* synthetic */ TNCUpdateSource access$000(TNCManager r0, int r1) {
        return r0.transInt2Enum(r1);
    }

    public static /* synthetic */ void access$100(TNCManager r0, boolean r1, TNCUpdateSource r2) {
        r0.doUpdateRemote(r1, r2);
    }

    public static /* synthetic */ List access$200(TNCManager r0, Map r1) {
        return r0.multiHeaderMap2List(r1);
    }

    public static /* synthetic */ ITncSandBox access$300(TNCManager r0) {
        return r0.mSandBox;
    }

    private static void addTNCExtraParam(UrlBuilder r3) {
        Object r0 = TTNetInit.getTTNetDepend();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof AbsOptionalTTNetDepend) == false) goto L16;
        Map<String, String> r1 = ((AbsOptionalTTNetDepend) r0).getTNCExtraParam();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        Map.Entry<String, String> r4 = r2.next();
        r3.addParam(r4.getKey(), r4.getValue());
        goto L12
    L19:
        return;
    L18:
        return;
    }

    private void doUpdateRemote(boolean r10, TNCUpdateSource r11) {
        TNCConfig r0 = getTNCConfig();
        if (r0 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "doUpdateRemote, " + r10);
    L8:
        long r3 = SystemClock.elapsedRealtime();
        if (r10 == false) goto L11;
    L16:
        this.mLastDoUpdateTime = r3;
        if (r11 != TNCUpdateSource.TTTNC) goto L19;
        this.mLastProbeSendTime = System.currentTimeMillis();
    L19:
        AppConfig.getInstance(this.mContext).doRefresh(r11, false);
        return;
    L11:
        if (((((long) r0.updateInterval) * 1000) + this.mLastDoUpdateTime) <= r3) goto L16;
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "doUpdateRemote, time limit");
        return;
    }

    private String getExceptionStr(Exception r2) {
        StringWriter r1 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r1));
        return r1.toString().toLowerCase();
    }

    public static String getGetDomainDefaultJson() {
        return mGetDomainDefaultJson;
    }

    public static synchronized TNCManager getInstance() {
        monitor-enter(TNCManager.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new TNCManager();     // Catch: Throwable -> L7
    L9:
        TNCManager r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(TNCManager.class);
        return r1;
    }

    private void handleTncProbe(Response r13, String r14) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (this.mIsMainProcess == true) goto L7;
        return;
    L7:
        String r15 = r13.header(TNC_PROBE_HEADER, null);
        if (TextUtils.isEmpty(r15) == true) goto L10;
        String[] r16 = r15.split(TNC_PROBE_HEADER_SECEPTOR);
        if (r16 == null) goto L50;
        if (r16.length != 2) goto L50;
        long r3 = 0;
        int r6 = Integer.parseInt(r16[0]);     // Catch: Throwable -> L24
        long r7 = Long.parseLong(r16[1]);     // Catch: Throwable -> L22
    L31:
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "handleTncProbe, local: " + this.mTncProbeCmd + TNC_PROBE_HEADER_SECEPTOR + this.mTncProbeVersion + " svr: " + r6 + TNC_PROBE_HEADER_SECEPTOR + r7 + " " + r14);
    L34:
        if (r7 > this.mTncProbeVersion) goto L36;
        return;
    L36:
        this.mTncProbeCmd = r6;
        this.mTncProbeVersion = r7;
        this.mLastProbeGetTime = System.currentTimeMillis();
        this.mContext.getSharedPreferences(TNC_SP_NAME, 0).edit().putInt("tnc_probe_cmd", r6).putLong("tnc_probe_version", r7).apply();
        if (this.mTncProbeCmd != 10000) goto L58;
        TNCConfig r17 = getTNCConfig();
        if (r17 != null) goto L41;
        return;
    L41:
        Random r0 = new Random(System.currentTimeMillis());
        int r18 = r17.updateRandomRange;
        if (r18 <= 0) goto L45;
        r3 = ((long) r0.nextInt(r18)) * 1000;
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d(TAG, "handleTncProbe, updateConfig delay: " + r3 + " " + r14);
    L47:
        sendUpdateMsg(true, r3, TNCUpdateSource.TTTNC);
        return;
    L58:
        return;
    L22:
        th = th;
    L26:
        th.printStackTrace();
        if (Logger.debug() == false) goto L29;
        a.y("handleTncProbe, probeProto except, ", r14, TAG);
    L29:
        r7 = 0;
    L24:
        th = th;
        r6 = 0;
    L50:
        if (Logger.debug() == false) goto L59;
        a.y("handleTncProbe, probeProto err, ", r14, TAG);
        return;
    L59:
        return;
    L10:
        if (Logger.debug() == false) goto L57;
        a.y("handleTncProbe, no probeProto, ", r14, TAG);
        return;
    }

    private boolean handleTncResponse(Context r9, TNCUpdateSource r10, String r11, String r12, String r13, String r14, boolean r15) {
    L26:
        return false;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "okhttp tnc response success, etag is " + r13 + ", tnc control " + r12);     // Catch: Exception -> L26
    L7:
        if (TextUtils.isEmpty(r13) == true) goto L9;
        AppConfig.getInstance(r9).setTncEtag(r13);     // Catch: Exception -> L26
    L9:
        getInstance().mTNCConfigHandler.setTncAbTest(r14);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r12) == true) goto L15;
        if (r12.equals("1") == false) goto L15;
        return true;
    L15:
        if (TextUtils.isEmpty(r11) == false) goto L17;
        return false;
    L17:
        JSONObject r3 = new JSONObject(r11);     // Catch: Exception -> L26
        ClientKeyManager.inst().OnNetConfigChanged(r11);     // Catch: Exception -> L26
        boolean r16 = AppConfig.getInstance(r9).handleResponse(r3, r10, System.currentTimeMillis(), r15);     // Catch: Exception -> L26
        if (r16 == false) goto L25;
        this.mConfigUpdateTime = System.currentTimeMillis();     // Catch: Exception -> L26
        if (this.mColdStartFinish == true) goto L22;
        this.mColdStartFinish = true;     // Catch: Exception -> L26
    L22:
        this.mConfigUpdateSuccess = true;     // Catch: Exception -> L26
        if (r10 != TNCUpdateSource.TTTNC) goto L25;
        this.mTncProbeSuccessVersion = this.mTncProbeVersion;     // Catch: Exception -> L26
    L25:
        return r16;
    }

    private List<Header> headerMap2List(Map<String, String> r5) {
        ArrayList r4 = new ArrayList();
        Iterator<String> r0 = r5.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        String r2 = r5.get(r1);
        if (TextUtils.isEmpty(r1) == true) goto L4;
        if (TextUtils.isEmpty(r2) == true) goto L4;
        r4.add(new Header(r1, r2));
        goto L4
    L10:
        return r4;
    }

    public static void initStoreRegionModule(final ICronetAppProvider r9) {
        String r0 = r9.getCarrierRegion();
        String r1 = r9.getSysRegion();
        String r2 = r9.getRegion();
        if (TextUtils.isEmpty(r0) == true) goto L6;
    L9:
        String r4 = r0;
        StoreRegionManager.inst().initStoreRegionRuleConfig(r4, r9.getStoreIdcRuleJSON(), r9.getAppInitialRegionInfo(), TTNetInit.getTTNetDepend().getContext(), new AnonymousClass1(r9));
        if (TextUtils.isEmpty(r0) == true) goto L13;
        mGetDomainDefaultJson = TTNetInit.getGetDomainConfigByRegion(r0);
    L13:
        if (TextUtils.isEmpty(mGetDomainDefaultJson) == false) goto L16;
        mGetDomainDefaultJson = r9.getGetDomainDefaultJSON();
    L16:
        if (Logger.debug() == false) goto L19;
        StringBuilder r10 = a.u("region: ", r0, " json: ");
        r10.append(mGetDomainDefaultJson);
        Logger.d(TAG, r10.toString());
        return;
    L19:
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r0 = r1;
        goto L9
    L8:
        r0 = r2;
        goto L9
    }

    private boolean isHttpRespCodeInBlack(int r4) {
        if (r4 >= 100) goto L5;
    L16:
        return true;
    L5:
        if (r4 >= 1000) goto L16;
        TNCConfig r3 = getTNCConfig();
        if (r3 != null) goto L10;
        return false;
    L10:
        if (TextUtils.isEmpty(r3.httpCodeBlack) == false) goto L12;
        return false;
    L12:
        if (r3.httpCodeBlack.contains("" + r4) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private boolean isHttpRespCodeOk(int r1) {
        if (r1 >= 200) goto L5;
        return false;
    L5:
        if (r1 >= 400) goto L10;
        return true;
    L10:
        return false;
    }

    private void loadProbeInfo() {
        SharedPreferences r0 = this.mContext.getSharedPreferences(TNC_SP_NAME, 0);
        this.mTncProbeCmd = r0.getInt("tnc_probe_cmd", 0);
        this.mTncProbeVersion = r0.getLong("tnc_probe_version", 0);
    }

    private List<Header> multiHeaderMap2List(Map<String, List<String>> r6) {
        ArrayList r5 = new ArrayList();
        Iterator<String> r0 = r6.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        List<String> r2 = r6.get(r1);
        if (r2 == null) goto L4;
        Iterator<String> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L4;
        r5.add(new Header(r1, r3.next()));
        goto L10
    L12:
        return r5;
    }

    private void resetTNCControlState() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "resetTNCControlState");
    L5:
        this.mReqToCnt = 0;
        this.mReqToApiMap.clear();
        this.mReqToIpMap.clear();
        this.mReqErrorCnt = 0;
        this.mReqErrApiMap.clear();
        this.mReqErrIpMap.clear();
    }

    private void sendUpdateMsg(boolean r4, long r5, TNCUpdateSource r7) {
        if (this.mHandler.hasMessages(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) == false) goto L5;
        return;
    L5:
        Message r0 = this.mHandler.obtainMessage();
        r0.what = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        r0.arg1 = r4 ? 1 : 0;
        r0.arg2 = r7.mValue;
        if (r5 <= 0) goto L8;
        this.mHandler.sendMessageDelayed(r0, r5);
        return;
    L8:
        this.mHandler.sendMessage(r0);
    }

    private TNCUpdateSource transInt2Enum(int r1) {
        if (r1 == 7) goto L34;
        if (r1 == 10) goto L32;
        if (r1 == 20) goto L30;
        if (r1 == 30) goto L28;
        switch(r1) {
            case -2: goto L26;
            case -1: goto L24;
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            default: goto L12;
        };
    L12:
        return TNCUpdateSource.TTSERVER;
    L14:
        return TNCUpdateSource.TTTNC;
    L16:
        return TNCUpdateSource.TTPOLL;
    L18:
        return TNCUpdateSource.TTERROR;
    L20:
        return TNCUpdateSource.TTSERVER;
    L22:
        return TNCUpdateSource.TTCACHE;
    L24:
        return TNCUpdateSource.TTHardCode;
    L26:
        return TNCUpdateSource.TTRESUME;
    L28:
        return TNCUpdateSource.TTCRONETFAILED;
    L30:
        return TNCUpdateSource.TTCRONET;
    L32:
        return TNCUpdateSource.TTREGION;
    L34:
        return TNCUpdateSource.PORTRETRY;
    }

    public boolean getDomainInternal(Context r24, boolean r25, TNCUpdateSource r26, String r27) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "getdomain internal, use retrofit okhttp: " + r25 + ", tnc source: " + r26);
    L5:
        ArrayList r0 = new ArrayList();
        if (AppConfig.getInstance(r24).getTncHostArrays() != null) goto L8;
    L15:
        r0.addAll(Arrays.asList(AppConfig.getInstance(r24).getConfigServers()));
    L16:
        this.mTNCSource = r26;
        this.mRequestStartTime = System.currentTimeMillis();
        Iterator r13 = r0.iterator();
    L18:
        if (r13.hasNext() == false) goto L87;
        UrlBuilder r3 = new UrlBuilder(a.u("https://", (String) r13.next(), "/get_domains/v5/").toString());
        r3.addParam("abi", Build.SUPPORTED_ABIS[0]);     // Catch: Throwable -> L23
        r3.addParam("tnc_src", r26.mValue);     // Catch: Throwable -> L23
        r3.addParam("okhttp_version", "4.2.228.16-pico");     // Catch: Throwable -> L23
        if (StoreRegionManager.inst().isStoreRegionRuleEnabled() == false) goto L25;
        r3.addParam("use_store_region_cookie", "1");     // Catch: Throwable -> L23
    L25:
        addTNCExtraParam(r3);     // Catch: Throwable -> L23
    L28:
        HashMap r1 = new HashMap();
        StoreRegionManager.inst().addStoreIdcHeaderForGetDomain(r1);
        boolean r10 = !TextUtils.isEmpty(StoreRegionManager.inst().getStoreRegion());
        if (TextUtils.isEmpty(r27) == true) goto L33;
        r1.put("x-tt-tnc-summary", r27);
    L33:
        if (r25 == false) goto L34;
        r3.addParam("aid", TTNetInit.getTTNetDepend().getAppId());
        r3.addParam("device_platform", "android");
        if (TTNetInit.getCronetProvider() == null) goto L50;
        r3.addParam("version_code", TTNetInit.getCronetProvider().getVersionCode());
        r3.addParam("channel", TTNetInit.getCronetProvider().getChannel());
    L50:
        ArrayList r5 = new ArrayList();
        Iterator r2 = r1.entrySet().iterator();
    L52:
        if (r2.hasNext() == false) goto L58;
        Map.Entry r6 = (Map.Entry) r2.next();
        if (TextUtils.isEmpty((CharSequence) r6.getKey()) == true) goto L52;
        if (TextUtils.isEmpty((CharSequence) r6.getValue()) == true) goto L52;
        r5.add(new Header((String) r6.getKey(), (String) r6.getValue()));
        goto L52
    L58:
        String r4 = r3.toString();
        LinkedHashMap r7 = new LinkedHashMap();
        Pair<String, String> r8 = UrlUtils.parseUrl(r4, r7);     // Catch: IOException -> L85
        String r9 = (String) r8.first;     // Catch: IOException -> L85
        String r19 = (String) r8.second;     // Catch: IOException -> L85
        INetworkApi r16 = (INetworkApi) RetrofitUtils.createSsService(r9, INetworkApi.class);
        if (r16 == null) goto L18;
        Call<String> r17 = r16.doGet(true, -1, r19, r7, r5, null);
        SsResponse<String> r11 = r17.execute();     // Catch: Throwable -> L70
        List<Header> r12 = r11.headers();     // Catch: Throwable -> L70
        String r14 = r11.body();     // Catch: Throwable -> L70
        if (this.mSandBox != null) goto L67;
    L72:
        String r15 = RetrofitUtils.getHeaderValueIgnoreCase(r12, StoreRegionManager.TNC_ETAG_HEADER);     // Catch: Throwable -> L70
        String r18 = RetrofitUtils.getHeaderValueIgnoreCase(r12, "x-tt-tnc-abtest");     // Catch: Throwable -> L70
        String r20 = RetrofitUtils.getHeaderValueIgnoreCase(r12, "x-tt-tnc-control");     // Catch: Throwable -> L70
        this.mTncConfigId = RetrofitUtils.getHeaderValueIgnoreCase(r12, StoreRegionManager.TNC_CONFIG_HEADER);     // Catch: Throwable -> L70
        this.mTncCanary = RetrofitUtils.getHeaderValueIgnoreCase(r12, "x-ss-canary");     // Catch: Throwable -> L70
        if (getInstance().handleTncResponse(r24, r26, r14, r20, r15, r18, r10) == true) goto L75;
    L74:
        r17.cancel();
        goto L18
    L75:
        r17.cancel();
        return true;
    L67:
        if (this.mSandBox.isTncResponseProceed(HttpMethodContrants.GET, r17.request().getUrl(), r12, r14) == true) goto L72;
        r17.cancel();
        return false;
    L70:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L80
        if (r17 == null) goto L18;
    L80:
        th = move-exception;
        if (r17 == null) goto L128;
        r17.cancel();
        throw th;
    L128:
        throw th;
    L85:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L34:
        GetDomainContext r21 = new GetDomainContext();
        r21.url = r3.toString();
        r21.useHttps = true;
        long r22 = System.currentTimeMillis();
    L45:
        th = move-exception;
        th.printStackTrace();
        goto L18
    L36:
        if (isTncRequestProceed(HttpMethodContrants.GET, r21.url, r1, "") == false) goto L37;
        Map<String, List<String>> r23 = new HashMap();     // Catch: Throwable -> L45
        String r28 = HttpURLConnClient.executeGet(r21.url, r1, r23, r21);     // Catch: Throwable -> L45
        if (isTncResponseProceed(HttpMethodContrants.GET, r21.url, r23, r28) == false) goto L40;
        r21.queryTime = System.currentTimeMillis() - r22;     // Catch: Throwable -> L45
        this.mTncCanary = r21.tncCanary;     // Catch: Throwable -> L45
        this.mTncConfigId = r21.tncConfigId;     // Catch: Throwable -> L45
        if (getInstance().handleTncResponse(r24, r26, r28, r21.tncControl, r21.tncEtag, r21.tncAbTest, r10) == false) goto L18;
        return true;
    L40:
        return false;
    L37:
        return false;
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L28
    L87:
        return false;
    L8:
        if (AppConfig.getInstance(r24).getTncHostArrays().size() == 0) goto L15;
        r0.addAll(AppConfig.getInstance(r24).getTncHostArrays());
        String[] r29 = AppConfig.getInstance(r24).getConfigServers();
        int r30 = r29.length;
        int r31 = 0;
    L10:
        if (r31 >= r30) goto L16;
        String r32 = r29[r31];
        if (r0.contains(r32) == true) goto L14;
        r0.add(r32);
    L14:
        r31 = r31 + 1;
        goto L10
    }

    public TNCConfig getTNCConfig() {
        TNCConfigHandler r0 = this.mTNCConfigHandler;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getTNCConfig();
    }

    public TNCConfigHandler getTNCConfigHandler() {
        return this.mTNCConfigHandler;
    }

    @Deprecated
    public Map<String, String> getTNCHostReplaceMap() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3TncBridge
    public JSONObject getTNCInfo() {
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L6
        r2.put("update_time", this.mConfigUpdateTime);     // Catch: JSONException -> L6
        r2.put(DBHelper.BATTERY_COL_SOURCE, this.mTNCSource.mValue);     // Catch: JSONException -> L6
        r2.put("cold_start", this.mColdStartFinish ? 1 : 0);     // Catch: JSONException -> L6
        r2.put("config_updated", this.mConfigUpdateSuccess ? 1 : 0);     // Catch: JSONException -> L6
        if (TextUtils.isEmpty(this.mTncConfigId) == true) goto L9;
        r2.put("config", this.mTncConfigId);     // Catch: JSONException -> L6
    L9:
        if (TextUtils.isEmpty(this.mTncCanary) == true) goto L11;
        r2.put("canary", this.mTncCanary);     // Catch: JSONException -> L6
    L11:
        r2.put("local_probe_version", this.mTncProbeSuccessVersion);     // Catch: JSONException -> L6
        String r3 = AppConfig.getInstance(this.mContext).getTncRules();     // Catch: JSONException -> L6
        if (TextUtils.isEmpty(r3) == true) goto L14;
        r2.put("rules", r3);     // Catch: JSONException -> L6
    L14:
        TNCConfigHandler r4 = this.mTNCConfigHandler;     // Catch: JSONException -> L6
        if (r4 != null) goto L17;
    L21:
        r1.put("data", r2);     // Catch: JSONException -> L6
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L6
        r5.put(RobotsPolicyContract.COL_VERSION, this.mTncProbeVersion);     // Catch: JSONException -> L6
        r5.put(EventConstants.EVENT_KEY_CMD, this.mTncProbeCmd);     // Catch: JSONException -> L6
        r5.put(ICronetClient.KEY_SEND_TIME, this.mLastProbeSendTime);     // Catch: JSONException -> L6
        r5.put("get_time", this.mLastProbeGetTime);     // Catch: JSONException -> L6
        r1.put("probe", r5);     // Catch: JSONException -> L6
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L6
        r6.put("probe_version", this.mTncProbeSuccessVersion);     // Catch: JSONException -> L6
        r6.put(DBHelper.BATTERY_COL_SOURCE, this.mTNCSource.mValue);     // Catch: JSONException -> L6
        r6.put("start_time", this.mRequestStartTime);     // Catch: JSONException -> L6
        r1.put("request", r6);     // Catch: JSONException -> L6
    L24:
        return r1;
    L17:
        if (TextUtils.isEmpty(r4.getRegion()) == true) goto L21;
        if (TextUtils.isEmpty(this.mTNCConfigHandler.getRegionSrc()) == true) goto L21;
        r2.put(CommonKey.KEY_REGION, this.mTNCConfigHandler.getRegion());     // Catch: JSONException -> L6
        r2.put(CronetDataStorageAccess.REGION_SOURCE, this.mTNCConfigHandler.getRegionSrc());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public void handleCronetInitFailed() {
        if (getTNCConfig() != null) goto L5;
        return;
    L5:
        if (ProcessUtils.isMainProcessByProcessFlag(this.mContext) == true) goto L7;
        return;
    L7:
        if (this.mCronetFailedTncSent.compareAndSet(false, true) == false) goto L12;
        sendUpdateMsg(true, 0, TNCUpdateSource.TTCRONETFAILED);
        return;
    }

    @Deprecated
    public String handleHostMapping(String r1) {
        return URLDispatcher.inst().handleHostMapping(r1);
    }

    public void handleRequestResult() {
    }

    public boolean handleTncConfigFromRegion(JSONObject r12, String r13, String r14, boolean r15) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "data: " + r12 + " etag: " + r13 + " tncAttr: " + r14 + " needUpdateTnc: " + r15);
    L6:
        if (r12 == null) goto L13;
        TNCConfigHandler r2 = this.mTNCConfigHandler;
        if (r2 == null) goto L10;
        r2.setTncAbTest("");
        boolean r16 = this.mTNCConfigHandler.handleConfigChanged(r12, TNCUpdateSource.TTSERVER, r13, r14, System.currentTimeMillis());
    L11:
        if (r16 == false) goto L14;
        StoreRegionManager.inst().setReceivedTNCRegionConfig();
    L14:
        if (r15 == false) goto L18;
        if (r16 == true) goto L18;
        Logger.d(TAG, "doUpdateRemote tnc");
        doUpdateRemote(true, TNCUpdateSource.TTREGION);
        return true;
    L18:
        return false;
    L10:
        r16 = false;
        goto L11
    L13:
        r16 = false;
        goto L14
    }

    public synchronized void initTnc(Context r5, boolean r6) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mInited == true) goto L15;
        this.mContext = r5;     // Catch: Throwable -> L9
        this.mIsMainProcess = r6;     // Catch: Throwable -> L9
        this.mTNCConfigHandler = new TNCConfigHandler(r5, r6);     // Catch: Throwable -> L9
        if (r6 == false) goto L12;
        loadProbeInfo();     // Catch: Throwable -> L9
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "initTnc, isMainProc: " + r6 + " probeCmd: " + this.mTncProbeCmd + " probeVersion: " + this.mTncProbeVersion);     // Catch: Throwable -> L9
    L14:
        this.mInited = true;     // Catch: Throwable -> L9
    L15:
        monitor-exit(this);
    }

    public boolean isTncRequestProceed(String r2, String r3, Map<String, String> r4, String r5) {
        if (this.mSandBox != null) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        List<Header> r6 = headerMap2List(r4);
        return this.mSandBox.isTncRequestProceed(r2, r3, r6, r5);
    }

    public boolean isTncResponseProceed(String r2, String r3, Map<String, List<String>> r4, String r5) {
        if (this.mSandBox != null) goto L6;
        return true;
    L6:
        List<Header> r6 = multiHeaderMap2List(r4);
        return this.mSandBox.isTncResponseProceed(r2, r3, r6, r5);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3TncBridge
    public synchronized void onOk3Response(Request r9, Response r10) {
        monitor-enter(this);
        if (r9 == null) goto L81;
        if (r10 == null) goto L81;
    L21:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsMainProcess == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (NetworkUtils.isNetworkAvailable(this.mContext) == true) goto L15;
        monitor-exit(this);
        return;
    L15:
        HttpUrl r11 = r9.url();     // Catch: Throwable -> L21
        String r3 = r11.scheme();     // Catch: Throwable -> L21
        String r4 = r11.host();     // Catch: Throwable -> L21
        String r12 = r11.encodedPath();     // Catch: Throwable -> L21
        int r5 = r10.code();     // Catch: Throwable -> L21
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r3) == true) goto L24;
        if ("https".equals(r3) == true) goto L24;
        monitor-exit(this);
        return;
    L24:
        if (TextUtils.isEmpty(r4) == false) goto L28;
        monitor-exit(this);
        return;
    L28:
        if (r10.networkResponse() != null) goto L32;
        monitor-exit(this);
        return;
    L32:
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "onOk3Response, url: " + r3 + "://" + r4 + "#" + r5);     // Catch: Throwable -> L21
    L34:
        TNCConfig r2 = getTNCConfig();     // Catch: Throwable -> L21
        if (r2 != null) goto L37;
    L39:
        if (r2 != null) goto L41;
    L77:
        monitor-exit(this);
        return;
    L41:
        if (r2.localEnable == false) goto L77;
        Map<String, Integer> r13 = r2.localHostFilterList;     // Catch: Throwable -> L21
        if (r13 != null) goto L46;
    L75:
        monitor-exit(this);
        return;
    L46:
        if (r13.size() <= 0) goto L75;
        if (r2.localHostFilterList.containsKey(r4) == false) goto L75;
        if (Logger.debug() == false) goto L53;
        Logger.d(TAG, "onOk3Response, url matched: " + r3 + "://" + r4 + "#" + r5 + " " + this.mReqToCnt + "#" + this.mReqToApiMap.size() + "#" + this.mReqToIpMap.size() + " " + this.mReqErrorCnt + "#" + this.mReqErrApiMap.size() + "#" + this.mReqErrIpMap.size());     // Catch: Throwable -> L21
    L53:
        if (r5 > 0) goto L55;
    L73:
        monitor-exit(this);
        return;
    L55:
        if (isHttpRespCodeOk(r5) == false) goto L62;
        if (this.mReqToCnt <= 0) goto L59;
    L60:
        resetTNCControlState();     // Catch: Throwable -> L21
        goto L73
    L59:
        if (this.mReqErrorCnt <= 0) goto L73;
    L62:
        if (isHttpRespCodeInBlack(r5) == true) goto L73;
        this.mReqErrorCnt++;     // Catch: Throwable -> L21
        this.mReqErrApiMap.put(r12, 0);     // Catch: Throwable -> L21
        this.mReqErrIpMap.put(r4, 0);     // Catch: Throwable -> L21
        if (this.mReqErrorCnt < r2.reqErrCnt) goto L73;
        if (this.mReqErrApiMap.size() < r2.reqErrApiCnt) goto L73;
        if (this.mReqErrIpMap.size() < r2.reqErrIpCnt) goto L73;
        if (Logger.debug() == false) goto L72;
        Logger.d(TAG, "onOk3Response, url doUpdate: " + r3 + "://" + r4 + "#" + r5);     // Catch: Throwable -> L21
    L72:
        sendUpdateMsg(false, 0, TNCUpdateSource.TTERROR);     // Catch: Throwable -> L21
        resetTNCControlState();     // Catch: Throwable -> L21
        goto L73
    L37:
        if (r2.probeEnable == false) goto L39;
        handleTncProbe(r10, r4);     // Catch: Throwable -> L21
    L81:
        monitor-exit(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3TncBridge
    public synchronized void onOk3Timeout(Request r8, Exception r9) {
        monitor-enter(this);
        if (r8 == null) goto L71;
        if (r9 == null) goto L71;
    L21:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsMainProcess == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (NetworkUtils.isNetworkAvailable(this.mContext) == true) goto L15;
        monitor-exit(this);
        return;
    L15:
        HttpUrl r10 = r8.url();     // Catch: Throwable -> L21
        String r2 = r10.scheme();     // Catch: Throwable -> L21
        String r3 = r10.host();     // Catch: Throwable -> L21
        String r11 = r10.encodedPath();     // Catch: Throwable -> L21
        String r12 = getExceptionStr(r9);     // Catch: Throwable -> L21
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r2) == true) goto L24;
        if ("https".equals(r2) == true) goto L24;
        monitor-exit(this);
        return;
    L24:
        if (TextUtils.isEmpty(r3) == false) goto L28;
        monitor-exit(this);
        return;
    L28:
        if (TextUtils.isEmpty(r12) == false) goto L30;
    L67:
        monitor-exit(this);
        return;
    L30:
        if (r12.contains("timeout") == false) goto L67;
        if (r12.contains("time out") == false) goto L67;
        if (r12.contains("unreachable") == true) goto L67;
        TNCConfig r4 = getTNCConfig();     // Catch: Throwable -> L21
        if (r4 != null) goto L39;
    L65:
        monitor-exit(this);
        return;
    L39:
        if (r4.localEnable == false) goto L65;
        Map<String, Integer> r5 = r4.localHostFilterList;     // Catch: Throwable -> L21
        if (r5 != null) goto L44;
    L63:
        monitor-exit(this);
        return;
    L44:
        if (r5.size() <= 0) goto L63;
        if (r4.localHostFilterList.containsKey(r3) == false) goto L63;
        if (Logger.debug() == false) goto L51;
        Logger.d(TAG, "onOk3Timeout, url matched: " + r2 + "://" + r3 + "#" + r12 + " " + this.mReqToCnt + "#" + this.mReqToApiMap.size() + "#" + this.mReqToIpMap.size() + " " + this.mReqErrorCnt + "#" + this.mReqErrApiMap.size() + "#" + this.mReqErrIpMap.size());     // Catch: Throwable -> L21
    L51:
        this.mReqToCnt++;     // Catch: Throwable -> L21
        this.mReqToApiMap.put(r11, 0);     // Catch: Throwable -> L21
        this.mReqToIpMap.put(r3, 0);     // Catch: Throwable -> L21
        if (this.mReqToCnt >= r4.reqToCnt) goto L54;
    L61:
        monitor-exit(this);
        return;
    L54:
        if (this.mReqToApiMap.size() < r4.reqToApiCnt) goto L61;
        if (this.mReqToIpMap.size() < r4.reqToIpCnt) goto L61;
        if (Logger.debug() == false) goto L60;
        Logger.d(TAG, "onOk3Timeout, url doUpate: " + r2 + "://" + r3);     // Catch: Throwable -> L21
    L60:
        sendUpdateMsg(false, 0, TNCUpdateSource.TTERROR);     // Catch: Throwable -> L21
        resetTNCControlState();     // Catch: Throwable -> L21
    L71:
        monitor-exit(this);
    }

    public void setTncSandbox(ITncSandBox r1) {
        this.mSandBox = r1;
        OkHttp3TTPSandBoxInterceptor.setTncSandbox(this.okTNCSandBox);
    }
}
