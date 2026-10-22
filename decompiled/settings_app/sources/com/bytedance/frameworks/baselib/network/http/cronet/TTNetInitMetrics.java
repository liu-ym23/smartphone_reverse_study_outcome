package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTNetInitMetrics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String HTTP_CALLBACK_ADDRESS = "http_callback";
    public static final String LOG_TYPE = "ttnet_init";
    public static final String LOG_TYPE_V2 = "ttnet_init_v2";
    private static final String MSBridgeML = "com.bytedance.mobsec.metasec.ml.MSB";
    private static final String MSBridgeMethod = "a";
    private static final String MSBridgeOV = "com.bytedance.mobsec.metasec.ov.MSB";
    public static final String TAG = "TTNetInitMetrics";
    private static final int TTNET_TYPE = 1;
    private static final String WS_CALLBACK_ADDRESS = "ws_callback";
    private static AtomicBoolean sCronetInitSuccess;
    private static volatile CopyOnWriteArrayList<TTNetInitCallback> sInitCallbackList;
    public static volatile TTNetInitMetrics sInstance;
    public String abTestStr;
    public long buildBuilderEnd;
    public long buildBuilderStart;
    public long buildContextConfigEnd;
    public long buildContextConfigStart;
    public long channelInitDuration;
    public long constructAppInfoSubsetEnd;
    public long constructAppInfoSubsetStart;
    public long constructThreadConfigCallbackEnd;
    public long constructThreadConfigCallbackStart;
    public long constructThreadConfigListEnd;
    public long constructThreadConfigListStart;
    public long contextBuilderDuration;
    public long createEngineEnd;
    public long createEngineStart;
    public long createEngineStartTime;
    public long cronetInitEnd;
    public String cronetInitTimingInfoJsonStr;
    public long executeWaitingTaskEndTime;
    public long initCookieManagerEnd;
    public long initCookieManagerStart;
    public long initMSSdkEnd;
    public long initMSSdkStart;
    public long initTTNetEnd;
    public long initTTNetStart;
    public long initTTNetStartTime;
    public long initThreadEnd;
    public long initThreadStart;
    public long installCertDuration;
    public boolean isMainProcess;
    public long loadCronetSoEnd;
    public long loadCronetSoStart;
    public CronetInitMode mode;
    public int netThreadPriority;
    public long netlogInitDuration;
    public long networkThreadEndTime;
    public long networkThreadStartTime;
    public long nqeDetectDuration;
    public long nqeInitDuration;
    public long preInitMSSdkEnd;
    public long preInitMSSdkStart;
    public long preconnectDuration;
    public long preconnectStartTime;
    public long prefsInitDuration;
    public long sslSessionDuration;
    public long tncConfigDuration;
    public long ttnetConfigDuration;
    public long updateAppinfoDuration;

    public static final enum CronetInitMode extends Enum<CronetInitMode> {
        private static final /* synthetic */ CronetInitMode[] $VALUES = null;
        public static final CronetInitMode BIZ_HTTPDNS_API = null;
        public static final CronetInitMode COOKIE_INIT_COMPLETE_API = null;
        public static final CronetInitMode DEPRECATED_API = null;
        public static final CronetInitMode FORCE_INIT = null;
        public static final CronetInitMode LAZY_INIT = null;
        public static final CronetInitMode NONE = null;
        public static final CronetInitMode PRE_INIT = null;
        public static final CronetInitMode ZSTD_API = null;
        final int initMode;

        public static CronetInitMode valueOf(String r1) {
            return (CronetInitMode) Enum.valueOf(CronetInitMode.class, r1);
        }

        public static CronetInitMode[] values() {
            return (CronetInitMode[]) $VALUES.clone();
        }

        static {
            CronetInitMode r0 = new CronetInitMode("NONE", 0, 0);
            NONE = r0;
            CronetInitMode r1 = new CronetInitMode("LAZY_INIT", 1, 1);
            LAZY_INIT = r1;
            CronetInitMode r3 = new CronetInitMode("PRE_INIT", 2, 2);
            PRE_INIT = r3;
            CronetInitMode r5 = new CronetInitMode("FORCE_INIT", 3, 3);
            FORCE_INIT = r5;
            CronetInitMode r7 = new CronetInitMode("DEPRECATED_API", 4, 4);
            DEPRECATED_API = r7;
            CronetInitMode r9 = new CronetInitMode("BIZ_HTTPDNS_API", 5, 5);
            BIZ_HTTPDNS_API = r9;
            CronetInitMode r11 = new CronetInitMode("ZSTD_API", 6, 6);
            ZSTD_API = r11;
            CronetInitMode r13 = new CronetInitMode("COOKIE_INIT_COMPLETE_API", 7, 7);
            COOKIE_INIT_COMPLETE_API = r13;
            $VALUES = new CronetInitMode[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private CronetInitMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.initMode = r3;
        }
    }

    public interface TTNetInitCallback {
        void ttnetInitSuccessCallback();
    }

    public TTNetInitMetrics() {
        this.mode = CronetInitMode.NONE;
        this.isMainProcess = true;
        this.initTTNetStartTime = 0;
        this.initTTNetStart = 0;
        this.preInitMSSdkStart = 0;
        this.preInitMSSdkEnd = 0;
        this.initTTNetEnd = 0;
        this.initCookieManagerStart = 0;
        this.initCookieManagerEnd = 0;
        this.createEngineStartTime = 0;
        this.createEngineStart = 0;
        this.constructAppInfoSubsetStart = 0;
        this.constructAppInfoSubsetEnd = 0;
        this.constructThreadConfigListStart = 0;
        this.constructThreadConfigListEnd = 0;
        this.constructThreadConfigCallbackStart = 0;
        this.constructThreadConfigCallbackEnd = 0;
        this.buildContextConfigStart = 0;
        this.buildContextConfigEnd = 0;
        this.buildBuilderStart = 0;
        this.buildBuilderEnd = 0;
        this.initMSSdkStart = 0;
        this.initMSSdkEnd = 0;
        this.createEngineEnd = 0;
        this.initThreadStart = 0;
        this.initThreadEnd = 0;
        this.loadCronetSoStart = 0;
        this.loadCronetSoEnd = 0;
        this.cronetInitEnd = 0;
        this.preconnectStartTime = 0;
        this.networkThreadStartTime = 0;
        this.networkThreadEndTime = 0;
        this.executeWaitingTaskEndTime = 0;
        this.nqeInitDuration = 0;
        this.prefsInitDuration = 0;
        this.channelInitDuration = 0;
        this.contextBuilderDuration = 0;
        this.tncConfigDuration = 0;
        this.updateAppinfoDuration = 0;
        this.netlogInitDuration = 0;
        this.nqeDetectDuration = 0;
        this.preconnectDuration = 0;
        this.sslSessionDuration = 0;
        this.ttnetConfigDuration = 0;
        this.installCertDuration = 0;
    }

    static /* synthetic */ CopyOnWriteArrayList access$000() {
        return sInitCallbackList;
    }

    static {
        sInitCallbackList = new CopyOnWriteArrayList();
        sCronetInitSuccess = new AtomicBoolean(false);
    }

    public static void setTTNetInitSuccessCallback(TTNetInitCallback r1) {
        sInitCallbackList.add(r1);
    }

    public static void setCronetInitSuccess(boolean r1) {
        sCronetInitSuccess.set(r1);
        if (sInitCallbackList.isEmpty() == false) goto L5;
        return;
    L5:
        final String r0 = "ttnet-init";
        new AnonymousClass1(r0).start();
    }

    public static boolean isCronetInitSuccess() {
        return sCronetInitSuccess.get();
    }

    public boolean isPreOrForceInitCronet() {
        if (this.mode != CronetInitMode.PRE_INIT) goto L5;
    L8:
        return true;
    L5:
        if (this.mode == CronetInitMode.FORCE_INIT) goto L8;
        return false;
    }

    public static TTNetInitMetrics inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TTNetInitMetrics.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TTNetInitMetrics();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTNetInitMetrics.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void initMSSdk(Context r4, List<Long> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.size() == 2) goto L7;
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "http address: " + r5.get(0) + " ws address: " + r5.get(1));
    L9:
        this.initMSSdkStart = System.nanoTime();
        if (setCallbackAddress(r4, r5) == false) goto L12;
    L14:
        this.initMSSdkEnd = System.nanoTime();
        return;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "init mssdk failed.");
        goto L14
    }

    public void initMSSdkFromTTNet(Context r3) {
        this.preInitMSSdkStart = System.nanoTime();
        setCallbackAddress(r3, null);
        this.preInitMSSdkEnd = System.nanoTime();
    }

    private boolean setCallbackAddress(Context r8, List<Long> r9) {
        HashMap r7 = null;
        Class<?> r0 = Class.forName(MSBridgeML);     // Catch: ClassNotFoundException -> L5
    L6:
        if (r0 != null) goto L9;
        r0 = Class.forName(MSBridgeOV);     // Catch: ClassNotFoundException -> L21
    L9:
        if (r0 != null) goto L12;
        return false;
    L12:
        if (r9 != null) goto L24;
    L16:
        r0.getMethod(MSBridgeMethod, new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r0, new Object[]{r8, 1, r7});     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        th.printStackTrace();
        return false;
    L24:
        if (r9.size() != 2) goto L16;
        r7 = new HashMap();     // Catch: Throwable -> L18
        r7.put(HTTP_CALLBACK_ADDRESS, String.valueOf(r9.get(0)));     // Catch: Throwable -> L18
        r7.put(WS_CALLBACK_ADDRESS, String.valueOf(r9.get(1)));     // Catch: Throwable -> L18
    L5:
        r0 = null;
        goto L6
    }

    public JSONObject constructTTNetInitTimingInfo() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r0.put("mode", this.mode.initMode);     // Catch: JSONException -> L16
        r0.put("is_main_process", this.isMainProcess);     // Catch: JSONException -> L16
        r0.put("net_thread_priority", this.netThreadPriority);     // Catch: JSONException -> L16
        r1.put("ttnet_start", this.initTTNetStartTime);     // Catch: JSONException -> L16
        r1.put("ttnet_end", convertTimeStamp(this.initTTNetEnd));     // Catch: JSONException -> L16
        r1.put("engine_start", convertTimeStamp(this.createEngineStart));     // Catch: JSONException -> L16
        r1.put("engine_end", convertTimeStamp(this.createEngineEnd));     // Catch: JSONException -> L16
        r1.put("init_start", convertTimeStamp(this.initThreadStart));     // Catch: JSONException -> L16
        r1.put("init_end", convertTimeStamp(this.initThreadEnd));     // Catch: JSONException -> L16
        r1.put("preconnect_start", this.preconnectStartTime);     // Catch: JSONException -> L16
        r2.put("builder_build", convertTimeTicksToDurationMs(this.buildBuilderStart, this.buildBuilderEnd));     // Catch: JSONException -> L16
        r2.put("load_cronet", convertTimeTicksToDurationMs(this.loadCronetSoStart, this.loadCronetSoEnd));     // Catch: JSONException -> L16
        r2.put("init_metasec", convertTimeTicksToDurationMs(this.preInitMSSdkStart, this.preInitMSSdkEnd));     // Catch: JSONException -> L16
        r2.put("init_ttnet", convertTimeTicksToDurationMs(this.initTTNetStart, this.initTTNetEnd));     // Catch: JSONException -> L16
        r2.put("init_mssdk", convertTimeTicksToDurationMs(this.initMSSdkStart, this.initMSSdkEnd));     // Catch: JSONException -> L16
        r2.put("create_engine", convertTimeTicksToDurationMs(this.createEngineStart, this.createEngineEnd));     // Catch: JSONException -> L16
        r2.put("init_thread", convertTimeTicksToDurationMs(this.initThreadStart, this.initThreadEnd));     // Catch: JSONException -> L16
        r2.put("init_total", convertTimeTicksToDurationMs(Math.min(this.initTTNetStartTime, this.createEngineStartTime) * 1000000, this.networkThreadEndTime * 1000000));     // Catch: JSONException -> L16
        r2.put("init_preconnect", convertTimeTicksToDurationMs(this.initTTNetStartTime, this.preconnectStartTime));     // Catch: JSONException -> L16
        long r4 = this.networkThreadStartTime;     // Catch: JSONException -> L16
        long r6 = this.networkThreadEndTime;     // Catch: JSONException -> L16
        long r9 = -1;
        if (r4 <= r6) goto L6;
        long r7 = -1;
    L7:
        r2.put("network_thread", r7);     // Catch: JSONException -> L16
        long r5 = this.networkThreadEndTime;     // Catch: JSONException -> L16
        long r8 = this.executeWaitingTaskEndTime;     // Catch: JSONException -> L16
        if (r5 > r8) goto L11;
        r9 = r8 - r5;     // Catch: JSONException -> L16
    L11:
        r2.put("exec_tasks", r9);     // Catch: JSONException -> L16
        r2.put("nqe_init", this.nqeInitDuration);     // Catch: JSONException -> L16
        r2.put("prefs_init", this.prefsInitDuration);     // Catch: JSONException -> L16
        r2.put("channel_init", this.channelInitDuration);     // Catch: JSONException -> L16
        r2.put("context_build", this.contextBuilderDuration);     // Catch: JSONException -> L16
        r2.put(MultiProcessFileUtils.KEY_TNC_CONFIG, this.tncConfigDuration);     // Catch: JSONException -> L16
        r2.put("update_appinfo", this.updateAppinfoDuration);     // Catch: JSONException -> L16
        r2.put("netlog_init", this.netlogInitDuration);     // Catch: JSONException -> L16
        r2.put("nqe_detect", this.nqeDetectDuration);     // Catch: JSONException -> L16
        r2.put("preconnect", this.preconnectDuration);     // Catch: JSONException -> L16
        r2.put("ssl_session", this.sslSessionDuration);     // Catch: JSONException -> L16
        r2.put("ttnet_config", this.ttnetConfigDuration);     // Catch: JSONException -> L16
        r2.put("install_cert", this.installCertDuration);     // Catch: JSONException -> L16
        r0.put("ttnet_timestamp", r1);     // Catch: JSONException -> L16
        r0.put("ttnet_duration", r2);     // Catch: JSONException -> L16
        r0.put(BaseHttpRequestInfo.KEY_ABTEST, this.abTestStr);     // Catch: JSONException -> L16
        goto L13
    L6:
        r7 = r6 - r4;     // Catch: JSONException -> L16
    L13:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "cronet init metrics json: " + r0.toString());
    L15:
        return r0;
    }

    public JSONObject constructTTNetInitTimingInfoV2(long r12) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L8
        r3.put("mssdk", convertTimeTicksToDurationUsStr(this.initMSSdkStart, this.initMSSdkEnd));     // Catch: Exception -> L8
        r3.put("app_info_subset", convertTimeTicksToDurationUsStr(this.constructAppInfoSubsetStart, this.constructAppInfoSubsetEnd));     // Catch: Exception -> L8
        r3.put("thread_config_list", convertTimeTicksToDurationUsStr(this.constructThreadConfigListStart, this.constructThreadConfigListEnd));     // Catch: Exception -> L8
        r3.put("build_ctx_config", convertTimeTicksToDurationUsStr(this.buildContextConfigStart, this.buildContextConfigEnd));     // Catch: Exception -> L8
        r3.put("init_total", convertTimeTicksToDurationUsStr(Math.min(this.initTTNetStartTime, this.createEngineStartTime) * 1000000, this.networkThreadEndTime * 1000000));     // Catch: Exception -> L8
        String r4 = "-1";
        if (r12 == (-1)) goto L6;
        r4 = convertTimeTicksToDurationUsStr(r12, this.initTTNetStart);     // Catch: Exception -> L8
    L6:
        r3.put("app_init_time", r4);     // Catch: Exception -> L8
        r2.put("cross_plfm", r3);     // Catch: Exception -> L8
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L8
        r13.put(LOG_TYPE, convertTimeTicksToDurationUsStr(this.initTTNetStart, this.initTTNetEnd));     // Catch: Exception -> L8
        r13.put("init_cookie_mgr", convertTimeTicksToDurationUsStr(this.initCookieManagerStart, this.initCookieManagerEnd));     // Catch: Exception -> L8
        r13.put("pre_init_mssdk", convertTimeTicksToDurationUsStr(this.preInitMSSdkStart, this.preInitMSSdkEnd));     // Catch: Exception -> L8
        r13.put("builder_build", convertTimeTicksToDurationUsStr(this.buildBuilderStart, this.buildBuilderEnd));     // Catch: Exception -> L8
        r13.put("create_engine", convertTimeTicksToDurationUsStr(this.createEngineStart, this.createEngineEnd));     // Catch: Exception -> L8
        r13.put("cronet_init_thread", convertTimeTicksToDurationUsStr(this.initThreadStart, this.initThreadEnd));     // Catch: Exception -> L8
        r13.put("cronet_load_so", convertTimeTicksToDurationUsStr(this.loadCronetSoStart, this.loadCronetSoEnd));     // Catch: Exception -> L8
        r13.put("thread_config_callback", convertTimeTicksToDurationUsStr(this.constructThreadConfigCallbackStart, this.constructThreadConfigCallbackEnd));     // Catch: Exception -> L8
        r2.put("android_spec", r13);     // Catch: Exception -> L8
        r1.put("durations_us", r2);     // Catch: Exception -> L8
        r1.put("cronet_init_mode", this.mode.initMode);     // Catch: Exception -> L8
        r0.put("ttnet_layer", r1);     // Catch: Exception -> L8
        r0.put("cronet_layer", new JSONObject(this.cronetInitTimingInfoJsonStr));     // Catch: Exception -> L8
        r0.put(BaseHttpRequestInfo.KEY_ABTEST, this.abTestStr);     // Catch: Exception -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public boolean checkTTNetLayerInitComplete() {
        if (this.initTTNetStartTime != 0) goto L5;
    L45:
        return false;
    L5:
        if (this.initTTNetStart == 0) goto L45;
        if (this.preInitMSSdkStart == 0) goto L45;
        if (this.preInitMSSdkEnd == 0) goto L45;
        if (this.initTTNetEnd == 0) goto L45;
        if (this.initCookieManagerStart == 0) goto L45;
        if (this.initCookieManagerEnd == 0) goto L45;
        if (this.createEngineStart == 0) goto L45;
        if (this.constructAppInfoSubsetStart == 0) goto L45;
        if (this.constructAppInfoSubsetEnd == 0) goto L45;
        if (this.constructThreadConfigListStart == 0) goto L45;
        if (this.constructThreadConfigListEnd == 0) goto L45;
        if (this.constructThreadConfigCallbackStart == 0) goto L45;
        if (this.constructThreadConfigCallbackEnd == 0) goto L45;
        if (this.buildContextConfigStart == 0) goto L45;
        if (this.buildContextConfigEnd == 0) goto L45;
        if (this.buildBuilderStart == 0) goto L45;
        if (this.buildBuilderEnd == 0) goto L45;
        if (this.initMSSdkStart == 0) goto L45;
        if (this.initMSSdkEnd == 0) goto L45;
        if (this.createEngineEnd == 0) goto L45;
        return true;
    }

    private long convertTimeStamp(long r3) {
        return (this.initTTNetStartTime + r3) - this.initTTNetStart;
    }

    private static String convertTimeTicksToDurationUsStr(long r0, long r2) {
        return String.valueOf(convertTimeTicksToDurationUs(r0, r2));
    }

    private static long convertTimeTicksToDurationUs(long r5, long r7) {
        if (r5 != 0) goto L5;
    L12:
        return -1;
    L5:
        if (r7 == 0) goto L12;
        if (r5 <= r7) goto L11;
        return -1;
    L11:
        return (r7 - r5) / 1000;
    }

    private static long convertTimeTicksToDurationMs(long r1, long r3) {
        long r2 = convertTimeTicksToDurationUs(r1, r3);
        if (r2 != (-1)) goto L6;
        return -1;
    L6:
        return r2 / 1000;
    }
}
