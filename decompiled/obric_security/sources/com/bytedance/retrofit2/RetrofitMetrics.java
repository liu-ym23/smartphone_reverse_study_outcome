package com.bytedance.retrofit2;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitMetrics {
    public long addClientKeyDuration;
    public boolean addClientKeySuccess;
    public long addCommonParamDuration;
    public int apiStreamReadCount;
    public long appCreateRetrofitStart;
    public long appCreateRetrofitStartUpTime;
    public long appLevelRequestStart;
    public long asyncDelayCount;
    public long beforeAllInterceptors;
    public Map<String, Object> bizExtraInfo;
    public int blockingQueueSize;
    public long bodyEncryptDuration;
    public long callExecuteStartTime;
    public long callServerInterceptorTime;
    public boolean callserverExecuteSuccess;
    public long checkReqTicketDuration;
    public long commandListenerDuration;
    public JSONObject concurrentRequest;
    public long contextThrottleSpeed;
    public long createSsHttpCallTime;
    public long cronetInitEnd;
    public long cronetInitStart;
    public long delayStartTimeStamp;
    public int delayState;
    public String delayStateName;
    public boolean delayedWithState;
    public long dispatchDelayTime;
    public JSONArray dispatchQueryActionInfo;
    public long encryptRequestDuration;
    public long enqueueCallbackEndTime;
    public long enqueueCallbackStartTime;
    public long enqueueTime;
    public long executeCallEndTime;
    public long executeCallStartTime;
    public long executeEndTime;
    public long executeTime;
    public Map<String, Long> extra;
    public String fallbackMessage;
    public int fallbackReason;
    public long filterDupQueryDuration;
    public long filterUrlDuration;
    public long genReqTicketDuration;
    public List<InterceptorInfo> interceptorRequestInfos;
    public List<InterceptorInfo> interceptorResponseInfos;
    public Throwable interceptorResponseThrowable;
    public boolean isConcurrent;
    public long openConnectionDuration;
    public int postBodyBufferSize;
    public long postCdnCacheVerifyDuration;
    public long preCdnCacheVerifyDuration;
    public long prepareRequestDuration;
    public int priorityLevel;
    public long queryFilterDuration;
    public long randomSendTime;
    public JSONObject requestCompressInfo;
    public String requestCompressType;
    public int requestCookieSourceType;
    private EncryptType requestEncryptType;
    public String requestFallbackMessage;
    public int requestFallbackReason;
    public Map<String, Long> requestInterceptDuration;
    public int requestPriorityLevel;
    public long requestVerifyDuration;
    public long responseChainTime;
    public String responseCompressType;
    public boolean responseConvertSuccess;
    public Map<String, Long> responseInterceptDuration;
    public int responseReadType;
    public long retrofitLogReportTime;
    public long retrofitMethodInvokeTime;
    public JSONObject rotationHostRetryInfo;
    public long setConnectionDuration;
    public long setThrottleNetSpeedDuration;
    public long ssHttpCallEnqueue;
    public long ssHttpCallExecute;
    public long stateDelayTime;
    public int streamParserCopyCount;
    public long syncDelayCount;
    public long toRequestEndTime;
    public long toRequestStartTime;
    public long toResponseEndTime;
    public long toResponseStartTime;
    public String traceCode;
    public String transactionId;
    public long tryNecessaryInitDuration;
    public String ttnetVersion;
    public long updateClientKeyDuration;
    public long upperAddCookieDurationUs;
    public long upperSaveCookieDurationUs;
    public URL url;
    public boolean usedByServiceMethodCache;

    public static final enum EncryptType extends Enum<EncryptType> {
        private static final /* synthetic */ EncryptType[] $VALUES = null;
        public static final EncryptType ENCRYPT_BODY = null;
        public static final EncryptType ENCRYPT_BOTH_QUERY_AND_BODY = null;
        public static final EncryptType ENCRYPT_NONE = null;
        public static final EncryptType ENCRYPT_QUERY = null;
        final int type;

        public static EncryptType valueOf(String r1) {
            return (EncryptType) Enum.valueOf(EncryptType.class, r1);
        }

        public static EncryptType[] values() {
            return (EncryptType[]) $VALUES.clone();
        }

        static {
            EncryptType r0 = new EncryptType("ENCRYPT_NONE", 0, 0);
            ENCRYPT_NONE = r0;
            EncryptType r1 = new EncryptType("ENCRYPT_QUERY", 1, 1);
            ENCRYPT_QUERY = r1;
            EncryptType r3 = new EncryptType("ENCRYPT_BODY", 2, 2);
            ENCRYPT_BODY = r3;
            EncryptType r5 = new EncryptType("ENCRYPT_BOTH_QUERY_AND_BODY", 3, 3);
            ENCRYPT_BOTH_QUERY_AND_BODY = r5;
            $VALUES = new EncryptType[]{r0, r1, r3, r5};
        }

        private EncryptType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }

        public int getValue() {
            return this.type;
        }
    }

    public interface ExtraKeys {
        public static final String RECEIVED_BYTE_COUNT = "receivedByteCount";
        public static final String SENT_BYTE_COUNT = "sentByteCount";
        public static final String STREAM_READ_BYTE_COUNT = "streamReadByteCount";
        public static final String STREAM_READ_TIME = "streamReadTime";
    }

    public class InterceptorInfo {
        public long end;
        public String name;
        public long start;
        final /* synthetic */ RetrofitMetrics this$0;

        public InterceptorInfo(RetrofitMetrics r1, String r2, long r3) {
            this.this$0 = r1;
            this.name = r2;
            this.start = r3;
            this.end = r3;
        }
    }

    public void setEncryptType(EncryptType r1) {
        this.requestEncryptType = r1;
    }

    public EncryptType getEncryptType() {
        return this.requestEncryptType;
    }

    public RetrofitMetrics() {
        this.url = null;
        this.streamParserCopyCount = -1;
        this.responseReadType = -1;
        this.requestEncryptType = EncryptType.ENCRYPT_NONE;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestFallbackReason = -1;
        this.requestFallbackMessage = "";
        this.transactionId = "";
        this.delayState = -1;
        this.delayStateName = null;
        this.stateDelayTime = -1;
        this.syncDelayCount = -1;
        this.asyncDelayCount = -1;
        this.delayStartTimeStamp = -1;
        this.randomSendTime = -1;
        this.callserverExecuteSuccess = false;
        this.interceptorResponseThrowable = null;
        this.requestInterceptDuration = new ConcurrentHashMap();
        this.responseInterceptDuration = new ConcurrentHashMap();
        this.filterUrlDuration = -1;
        this.addCommonParamDuration = -1;
        this.requestVerifyDuration = -1;
        this.filterDupQueryDuration = -1;
        this.encryptRequestDuration = -1;
        this.genReqTicketDuration = -1;
        this.checkReqTicketDuration = -1;
        this.preCdnCacheVerifyDuration = -1;
        this.addClientKeyDuration = -1;
        this.updateClientKeyDuration = -1;
        this.postCdnCacheVerifyDuration = -1;
        this.commandListenerDuration = -1;
        this.queryFilterDuration = -1;
        this.bodyEncryptDuration = -1;
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.responseConvertSuccess = true;
        this.priorityLevel = -1;
        this.requestPriorityLevel = -1;
        this.contextThrottleSpeed = -1;
        this.responseCompressType = "";
        this.requestCompressType = "";
        this.apiStreamReadCount = -1;
        this.setThrottleNetSpeedDuration = -1;
        this.tryNecessaryInitDuration = -1;
        this.openConnectionDuration = -1;
        this.setConnectionDuration = -1;
        this.prepareRequestDuration = -1;
        this.upperAddCookieDurationUs = -1;
        this.upperSaveCookieDurationUs = -1;
        this.requestCookieSourceType = -1;
        this.bizExtraInfo = new HashMap();
        this.blockingQueueSize = 0;
        this.interceptorRequestInfos = new ArrayList();
        this.interceptorResponseInfos = new ArrayList();
    }

    public RetrofitMetrics(boolean r7) {
        this.url = null;
        this.streamParserCopyCount = -1;
        this.responseReadType = -1;
        this.requestEncryptType = EncryptType.ENCRYPT_NONE;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestFallbackReason = -1;
        this.requestFallbackMessage = "";
        this.transactionId = "";
        this.delayState = -1;
        this.delayStateName = null;
        this.stateDelayTime = -1;
        this.syncDelayCount = -1;
        this.asyncDelayCount = -1;
        this.delayStartTimeStamp = -1;
        this.randomSendTime = -1;
        this.callserverExecuteSuccess = false;
        this.interceptorResponseThrowable = null;
        this.requestInterceptDuration = new ConcurrentHashMap();
        this.responseInterceptDuration = new ConcurrentHashMap();
        this.filterUrlDuration = -1;
        this.addCommonParamDuration = -1;
        this.requestVerifyDuration = -1;
        this.filterDupQueryDuration = -1;
        this.encryptRequestDuration = -1;
        this.genReqTicketDuration = -1;
        this.checkReqTicketDuration = -1;
        this.preCdnCacheVerifyDuration = -1;
        this.addClientKeyDuration = -1;
        this.updateClientKeyDuration = -1;
        this.postCdnCacheVerifyDuration = -1;
        this.commandListenerDuration = -1;
        this.queryFilterDuration = -1;
        this.bodyEncryptDuration = -1;
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.responseConvertSuccess = true;
        this.priorityLevel = -1;
        this.requestPriorityLevel = -1;
        this.contextThrottleSpeed = -1;
        this.responseCompressType = "";
        this.requestCompressType = "";
        this.apiStreamReadCount = -1;
        this.setThrottleNetSpeedDuration = -1;
        this.tryNecessaryInitDuration = -1;
        this.openConnectionDuration = -1;
        this.setConnectionDuration = -1;
        this.prepareRequestDuration = -1;
        this.upperAddCookieDurationUs = -1;
        this.upperSaveCookieDurationUs = -1;
        this.requestCookieSourceType = -1;
        this.bizExtraInfo = new HashMap();
        this.blockingQueueSize = 0;
        this.interceptorRequestInfos = new ArrayList();
        this.interceptorResponseInfos = new ArrayList();
        this.appCreateRetrofitStart = System.currentTimeMillis();
        long r0 = SystemClock.uptimeMillis();
        this.appCreateRetrofitStartUpTime = r0;
        this.usedByServiceMethodCache = r7;
        if (r7 == false) goto L6;
        this.retrofitMethodInvokeTime = r0;
        this.createSsHttpCallTime = r0;
        return;
    }

    public RetrofitMetrics cloneMetrics() {
        RetrofitMetrics r0 = new RetrofitMetrics();
        r0.appCreateRetrofitStartUpTime = this.appCreateRetrofitStartUpTime;
        r0.appCreateRetrofitStart = this.appLevelRequestStart;
        r0.usedByServiceMethodCache = this.usedByServiceMethodCache;
        r0.retrofitMethodInvokeTime = this.retrofitMethodInvokeTime;
        r0.createSsHttpCallTime = this.createSsHttpCallTime;
        return r0;
    }

    public RetrofitMetrics(long r7, long r9) {
        this.url = null;
        this.streamParserCopyCount = -1;
        this.responseReadType = -1;
        this.requestEncryptType = EncryptType.ENCRYPT_NONE;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestFallbackReason = -1;
        this.requestFallbackMessage = "";
        this.transactionId = "";
        this.delayState = -1;
        this.delayStateName = null;
        this.stateDelayTime = -1;
        this.syncDelayCount = -1;
        this.asyncDelayCount = -1;
        this.delayStartTimeStamp = -1;
        this.randomSendTime = -1;
        this.callserverExecuteSuccess = false;
        this.interceptorResponseThrowable = null;
        this.requestInterceptDuration = new ConcurrentHashMap();
        this.responseInterceptDuration = new ConcurrentHashMap();
        this.filterUrlDuration = -1;
        this.addCommonParamDuration = -1;
        this.requestVerifyDuration = -1;
        this.filterDupQueryDuration = -1;
        this.encryptRequestDuration = -1;
        this.genReqTicketDuration = -1;
        this.checkReqTicketDuration = -1;
        this.preCdnCacheVerifyDuration = -1;
        this.addClientKeyDuration = -1;
        this.updateClientKeyDuration = -1;
        this.postCdnCacheVerifyDuration = -1;
        this.commandListenerDuration = -1;
        this.queryFilterDuration = -1;
        this.bodyEncryptDuration = -1;
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.responseConvertSuccess = true;
        this.priorityLevel = -1;
        this.requestPriorityLevel = -1;
        this.contextThrottleSpeed = -1;
        this.responseCompressType = "";
        this.requestCompressType = "";
        this.apiStreamReadCount = -1;
        this.setThrottleNetSpeedDuration = -1;
        this.tryNecessaryInitDuration = -1;
        this.openConnectionDuration = -1;
        this.setConnectionDuration = -1;
        this.prepareRequestDuration = -1;
        this.upperAddCookieDurationUs = -1;
        this.upperSaveCookieDurationUs = -1;
        this.requestCookieSourceType = -1;
        this.bizExtraInfo = new HashMap();
        this.blockingQueueSize = 0;
        this.interceptorRequestInfos = new ArrayList();
        this.interceptorResponseInfos = new ArrayList();
        this.appLevelRequestStart = r7;
        this.beforeAllInterceptors = r9;
    }

    public String getRetrofitLog() {
        JSONObject r0 = new JSONObject();
    L39:
        e = move-exception;
        e.printStackTrace();
    L42:
        return r0.toString();
    L4:
        if (this.fallbackReason == (-1)) goto L6;
        r0.put("model", getModelInfoWhenFallback());     // Catch: JSONException -> L39
    L6:
        JSONObject r1 = this.concurrentRequest;     // Catch: JSONException -> L39
        if (r1 == null) goto L9;
        r0.put("concurrentRequest", r1);     // Catch: JSONException -> L39
    L9:
        r0.put("concurrent", this.isConcurrent);     // Catch: JSONException -> L39
        r0.put(TraceStatsConsts.STATS_BASE_MODULE, getBaseTimingInfo());     // Catch: JSONException -> L39
        r0.put("callback", getCallbackTimingInfo());     // Catch: JSONException -> L39
        r0.put("interceptor", getInterceptorTimingInfo());     // Catch: JSONException -> L39
        r0.put("ttnetVersion", this.ttnetVersion);     // Catch: JSONException -> L39
        JSONArray r2 = this.dispatchQueryActionInfo;     // Catch: JSONException -> L39
        if (r2 != null) goto L12;
    L14:
        JSONObject r3 = this.requestCompressInfo;     // Catch: JSONException -> L39
        if (r3 == null) goto L17;
        r0.put(com.bytedance.compression.zstd.BuildConfig.FLAVOR, r3);     // Catch: JSONException -> L39
    L17:
        int r4 = this.postBodyBufferSize;     // Catch: JSONException -> L39
        if (r4 <= 0) goto L20;
        r0.put("postBufferSize", r4);     // Catch: JSONException -> L39
    L20:
        int r5 = this.blockingQueueSize;     // Catch: JSONException -> L39
        if (r5 <= 0) goto L23;
        r0.put("blockingQueueSize", r5);     // Catch: JSONException -> L39
    L23:
        int r6 = this.apiStreamReadCount;     // Catch: JSONException -> L39
        if (r6 <= 0) goto L26;
        r0.put("apiStreamReadCount", r6);     // Catch: JSONException -> L39
    L26:
        r0.put("stateDelayed", this.delayedWithState);     // Catch: JSONException -> L39
        r0.put("stateDelayTime", this.stateDelayTime);     // Catch: JSONException -> L39
        r0.put("syncCount", this.syncDelayCount);     // Catch: JSONException -> L39
        r0.put("asyncCount", this.asyncDelayCount);     // Catch: JSONException -> L39
        r0.put("delayState", this.delayState);     // Catch: JSONException -> L39
        r0.put("random", this.randomSendTime);     // Catch: JSONException -> L39
        if (TextUtils.isEmpty(this.delayStateName) == true) goto L30;
        r0.put("stateName", this.delayStateName);     // Catch: JSONException -> L39
    L30:
        if (this.addClientKeySuccess == false) goto L32;
        r0.put("cli_key", true);     // Catch: JSONException -> L39
    L32:
        int r7 = this.streamParserCopyCount;     // Catch: JSONException -> L39
        if (r7 < 0) goto L35;
        r0.put("cp_cnt", r7);     // Catch: JSONException -> L39
    L35:
        int r8 = this.responseReadType;     // Catch: JSONException -> L39
        if (r8 < 0) goto L42;
        r0.put("read_type", r8);     // Catch: JSONException -> L39
        goto L42
    L12:
        if (r2.length() <= 0) goto L14;
        r0.put("actionInfo", this.dispatchQueryActionInfo);     // Catch: JSONException -> L39
        goto L14
    }

    private JSONObject getModelInfoWhenFallback() {
        JSONObject r3 = new JSONObject();
        r3.put("model", Build.MODEL);     // Catch: JSONException -> L10
        String r0 = "";
        String[] r1 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L10
        if (r1 != null) goto L6;
    L8:
        r3.put("abis", r0);     // Catch: JSONException -> L10
    L12:
        return r3;
    L6:
        if (r1.length <= 0) goto L8;
        r0 = Arrays.asList(r1).toString();     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private JSONObject getBaseTimingInfo() {
        JSONObject r8 = new JSONObject();
        r8.put("fallback", this.fallbackReason);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.fallbackMessage) == true) goto L6;
        r8.put("fallbackMessage", this.fallbackMessage);     // Catch: JSONException -> L23
    L6:
        r8.put("reqFallback", this.requestFallbackReason);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.requestFallbackMessage) == true) goto L9;
        r8.put("reqFallbackMsg", this.requestFallbackMessage);     // Catch: JSONException -> L23
    L9:
        r8.put("createRetrofitTime", this.appCreateRetrofitStart);     // Catch: JSONException -> L23
        r8.put("appRequestStartTime", this.appLevelRequestStart);     // Catch: JSONException -> L23
        r8.put("beforeAllInterceptTime", this.beforeAllInterceptors);     // Catch: JSONException -> L23
        r8.put("callServerInterceptTime", this.callServerInterceptorTime);     // Catch: JSONException -> L23
        r8.put("callExecuteStartTime", this.callExecuteStartTime);     // Catch: JSONException -> L23
        r8.put("reportTime", this.retrofitLogReportTime);     // Catch: JSONException -> L23
        r8.put("delayWait", this.dispatchDelayTime);     // Catch: JSONException -> L23
        if (this.requestEncryptType == EncryptType.ENCRYPT_NONE) goto L13;
        r8.put("encrypt", this.requestEncryptType.getValue());     // Catch: JSONException -> L23
    L13:
        if (TextUtils.isEmpty(this.transactionId) == true) goto L15;
        r8.put("transactionId", this.transactionId);     // Catch: JSONException -> L23
    L15:
        long r0 = this.upperAddCookieDurationUs;     // Catch: JSONException -> L23
        if (r0 < 0) goto L18;
        r8.put(ICronetClient.KEY_UPPER_ADD_COOKIE_US, r0);     // Catch: JSONException -> L23
    L18:
        long r1 = this.upperSaveCookieDurationUs;     // Catch: JSONException -> L23
        if (r1 < 0) goto L21;
        r8.put(ICronetClient.KEY_UPPER_SAVE_COOKIE_US, r1);     // Catch: JSONException -> L23
    L21:
        r8.put("request_cookie_source", this.requestCookieSourceType);     // Catch: JSONException -> L23
    L25:
        boolean r7 = validateAndSetTimingValue(r8, "loadServiceMethod", this.retrofitMethodInvokeTime, this.createSsHttpCallTime, true);
        long r3 = this.enqueueTime;
        if (r3 <= 0) goto L28;
        boolean r11 = validateAndSetTimingValue(r8, "enqueueWait", r3, this.responseChainTime, r7);
        validateAndSetTimingValue(r8, "biz_start_after_cronet_start", this.cronetInitStart / 1000, this.ssHttpCallEnqueue / 1000, true);
        validateAndSetTimingValue(r8, "biz_start_before_cronet_end", this.ssHttpCallEnqueue / 1000, this.cronetInitEnd / 1000, true);
    L29:
        long r4 = this.executeCallStartTime;
        long r5 = this.executeCallEndTime;
        boolean r9 = validateAndSetTimingValue(r8, "executeCall", r4, r5, r11);
        boolean r10 = validateAndSetTimingValue(r8, "requestParse", this.toRequestStartTime, this.toRequestEndTime, r9);
        validateAndSetTimingValue(r8, "responseParse", this.toResponseStartTime, this.toResponseEndTime, r10);
        return r8;
    L28:
        r11 = validateAndSetTimingValue(r8, "executeWait", this.executeTime, this.responseChainTime, r7);
        validateAndSetTimingValue(r8, "biz_start_after_cronet_start", this.cronetInitStart / 1000, this.ssHttpCallExecute / 1000, true);
        validateAndSetTimingValue(r8, "biz_start_before_cronet_end", this.ssHttpCallExecute / 1000, this.cronetInitEnd / 1000, true);
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    private JSONObject getCallbackTimingInfo() {
        JSONObject r0 = new JSONObject();
        r0.put("filterUrl", this.filterUrlDuration);     // Catch: JSONException -> L8
        r0.put("addCommonParam", this.addCommonParamDuration);     // Catch: JSONException -> L8
        r0.put("requestVerify", this.requestVerifyDuration);     // Catch: JSONException -> L8
        r0.put("encryptRequest", this.encryptRequestDuration);     // Catch: JSONException -> L8
        r0.put("genReqTicket", this.genReqTicketDuration);     // Catch: JSONException -> L8
        r0.put("checkReqTicket", this.checkReqTicketDuration);     // Catch: JSONException -> L8
        r0.put("preCdnVerify", this.preCdnCacheVerifyDuration);     // Catch: JSONException -> L8
        r0.put("postCdnVerify", this.postCdnCacheVerifyDuration);     // Catch: JSONException -> L8
        r0.put("addClientKey", this.addClientKeyDuration);     // Catch: JSONException -> L8
        r0.put("updateClientKey", this.updateClientKeyDuration);     // Catch: JSONException -> L8
        r0.put("commandListener", this.commandListenerDuration);     // Catch: JSONException -> L8
        r0.put("filterDupQuery", this.filterDupQueryDuration);     // Catch: JSONException -> L8
        r0.put("queryFilter", this.queryFilterDuration);     // Catch: JSONException -> L8
        long r1 = this.bodyEncryptDuration;     // Catch: JSONException -> L8
        if (r1 < 0) goto L6;
        r0.put("bodyEncrypt", r1);     // Catch: JSONException -> L8
    L6:
        r0.put("setSpeed", this.setThrottleNetSpeedDuration);     // Catch: JSONException -> L8
        r0.put("tryInit", this.tryNecessaryInitDuration);     // Catch: JSONException -> L8
        r0.put("openConn", this.openConnectionDuration);     // Catch: JSONException -> L8
        r0.put("setConn", this.setConnectionDuration);     // Catch: JSONException -> L8
        r0.put("prepareReq", this.prepareRequestDuration);     // Catch: JSONException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private JSONObject getInterceptorTimingInfo() {
        JSONObject r0 = new JSONObject();
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r0;
    L4:
        if (this.requestInterceptDuration.isEmpty() == true) goto L11;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r2 = this.requestInterceptDuration.entrySet().iterator();     // Catch: JSONException -> L18
    L7:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, Long> r3 = r2.next();     // Catch: JSONException -> L18
        r1.put(r3.getKey(), r3.getValue());     // Catch: JSONException -> L18
        goto L7
    L9:
        r0.put("request", r1);     // Catch: JSONException -> L18
    L11:
        if (this.responseInterceptDuration.isEmpty() == true) goto L20;
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r5 = this.responseInterceptDuration.entrySet().iterator();     // Catch: JSONException -> L18
    L14:
        if (r5.hasNext() == false) goto L16;
        Map.Entry<String, Long> r6 = r5.next();     // Catch: JSONException -> L18
        r4.put(r6.getKey(), r6.getValue());     // Catch: JSONException -> L18
        goto L14
    L16:
        r0.put(ApmTrafficStats.TTNET_RESPONSE, r4);     // Catch: JSONException -> L18
        goto L20
    }

    private boolean validateAndSetTimingValue(JSONObject r1, String r2, long r3, long r5, boolean r7) {
        if (r7 == true) goto L5;
    L10:
        r1.put(r2, -1);     // Catch: JSONException -> L12
        return false;
    L5:
        if (r3 > r5) goto L10;
        r1.put(r2, r5 - r3);     // Catch: JSONException -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void recordInterceptorRequestStart(Interceptor r5) {
        String r6 = r5.getClass().getName();
        if (TextUtils.isEmpty(r6) == true) goto L6;
        String r7 = r6.substring(r6.lastIndexOf(46) + 1);
        this.interceptorRequestInfos.add(new InterceptorInfo(this, r7, SystemClock.uptimeMillis()));
        return;
    }

    public void recordInterceptorRequestEnd() {
        if (this.interceptorRequestInfos.size() > 0) goto L5;
        return;
    L5:
        List<InterceptorInfo> r2 = this.interceptorRequestInfos;
        r2.get(r2.size() - 1).end = SystemClock.uptimeMillis();
    }

    public void recordInterceptorResponseStart(Interceptor r5) {
        String r6 = r5.getClass().getName();
        if (TextUtils.isEmpty(r6) == true) goto L6;
        String r7 = r6.substring(r6.lastIndexOf(46) + 1);
        this.interceptorResponseInfos.add(new InterceptorInfo(this, r7, SystemClock.uptimeMillis()));
        return;
    }

    public void recordInterceptorResponseEnd() {
        if (this.interceptorResponseInfos.size() > 0) goto L5;
        return;
    L5:
        List<InterceptorInfo> r2 = this.interceptorResponseInfos;
        r2.get(r2.size() - 1).end = SystemClock.uptimeMillis();
    }

    public JSONObject getRealChainInterceptorTimingInfo() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        Iterator<InterceptorInfo> r3 = this.interceptorRequestInfos.iterator();     // Catch: JSONException -> L13
    L5:
        if (r3.hasNext() == false) goto L7;
        InterceptorInfo r4 = r3.next();     // Catch: JSONException -> L13
        r0.put(r4.name, r4.end - r4.start);     // Catch: JSONException -> L13
        goto L5
    L7:
        Iterator<InterceptorInfo> r10 = this.interceptorResponseInfos.iterator();     // Catch: JSONException -> L13
    L9:
        if (r10.hasNext() == false) goto L11;
        InterceptorInfo r5 = r10.next();     // Catch: JSONException -> L13
        r1.put(r5.name, r5.end - r5.start);     // Catch: JSONException -> L13
        goto L9
    L11:
        r2.put("interceptorRequestInfo", r0);     // Catch: JSONException -> L13
        r2.put("interceptorResponseInfo", r1);     // Catch: JSONException -> L13
    L15:
        return r2;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
