package com.bytedance.apm.perf.traffic;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.listener.ITrafficCallback;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.Pair;
import com.bytedance.apm.util.TopK;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.apm6.util.cache.LimitedQueue;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TrafficCollector extends AbstractPerfCollector {
    private static int BACK_APP = 2;
    private static final int ERROR_RESULT = -1;
    private static final String EXCEPTION_TYPE = "TrafficException";
    private static int FRONT_APP = 1;
    private static int FRONT_UNKNOWN = 0;
    private static final int MAX_SIZE = 20;
    private static final String SPLIT = "$";
    private static final String TAG = "APM-Traffic-Detail ";
    private static final String TRAFFIC_HIGH_FREQ = "TrafficHighTreq";
    private static final String TRAFFIC_TOPK = "TrafficTopK";
    private static LimitedQueue<GeneralLegacyEvent> cache = null;
    private static LimitedQueue<String> keys = null;
    private static String sBgType = "bg_never_front";
    private static ITrafficCallback trafficCallback;
    private JSONObject config;
    private long mBizTotalBytes;
    private long mHighFreqCountThreshold;
    private long mInitTrafficBytes;
    private int mLastFront;
    private long mLastMobileBackBytes;
    private long mLastMobileFrontBytes;
    private long mLastTotalBytes;
    private long mLastTs;
    private long mLastWIFIBackBytes;
    private long mLastWIFIFrontBytes;
    private long mTraffic10minutesBackThresholdBytes;
    private long mTraffic10minutesThresholdBytes;
    private TrafficStatisticWrapper mTrafficStatisticWrapper;
    private Map<String, Pair<Long, Long>> metricMobileTrafficMap;
    private Map<String, Pair<Long, Long>> metricTrafficMap;
    private Map<String, Pair<Long, Long>> metricWifiTrafficMap;
    private long recordUsageThreshold;

    private static class Holder {
        private static final TrafficCollector sInstance = null;

        private Holder() {
        }

        static /* synthetic */ TrafficCollector access$100() {
            return sInstance;
        }

        static {
            sInstance = new TrafficCollector(null);
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return true;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return 600000;
    }

    /* synthetic */ TrafficCollector(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ String access$1000(TrafficCollector r0) {
        return r0.mCollectorSettingKey;
    }

    static /* synthetic */ Map access$200(TrafficCollector r0) {
        return r0.metricTrafficMap;
    }

    static /* synthetic */ Map access$202(TrafficCollector r0, Map r1) {
        r0.metricTrafficMap = r1;
        return r1;
    }

    static /* synthetic */ TrafficStatisticWrapper access$300(TrafficCollector r0) {
        return r0.mTrafficStatisticWrapper;
    }

    static /* synthetic */ Map access$400(TrafficCollector r0) {
        return r0.metricWifiTrafficMap;
    }

    static /* synthetic */ Map access$402(TrafficCollector r0, Map r1) {
        r0.metricWifiTrafficMap = r1;
        return r1;
    }

    static /* synthetic */ Map access$500(TrafficCollector r0) {
        return r0.metricMobileTrafficMap;
    }

    static /* synthetic */ Map access$502(TrafficCollector r0, Map r1) {
        r0.metricMobileTrafficMap = r1;
        return r1;
    }

    static /* synthetic */ String access$600(TrafficCollector r0) {
        return r0.mCollectorSettingKey;
    }

    static /* synthetic */ JSONObject access$700(TrafficCollector r0) {
        return r0.config;
    }

    static /* synthetic */ LimitedQueue access$800() {
        return cache;
    }

    static /* synthetic */ LimitedQueue access$900() {
        return keys;
    }

    static {
        cache = new LimitedQueue(20);
        keys = new LimitedQueue(20);
    }

    public static TrafficCollector getInstance() {
        return Holder.access$100();
    }

    private TrafficCollector() {
        this.mTraffic10minutesThresholdBytes = 500000000;
        this.recordUsageThreshold = 0;
        this.mTraffic10minutesBackThresholdBytes = 1;
        this.mLastTotalBytes = -1;
        this.mLastMobileBackBytes = 0;
        this.mLastMobileFrontBytes = 0;
        this.mLastWIFIBackBytes = 0;
        this.mLastWIFIFrontBytes = 0;
        this.mInitTrafficBytes = 0;
        this.mLastFront = FRONT_UNKNOWN;
        this.mCollectorSettingKey = "traffic";
        TrafficStatisticWrapper r0 = TrafficStatisticWrapper.getInstance();
        this.mTrafficStatisticWrapper = r0;
        r0.onStatusChange(isBackground());
    }

    public static void setCallback(ITrafficCallback r0) {
        trafficCallback = r0;
    }

    public synchronized void startMetric(final String r3, final boolean r4) {
        monitor-enter(this);
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r3, r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void stopMetric(final String r3) {
        monitor-enter(this);
        AsyncEventManager.getInstance().post(new AnonymousClass2(this, r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void onInit() {
        SharedPreferences r4 = ApmContext.getContext().getSharedPreferences(ApmTrafficStats.SP_TRAFFIC, 0);
        long r8 = r4.getLong("init", -1);
        long r13 = r4.getLong(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, 0);
        if (r8 <= (-1)) goto L22;
        long r0 = r4.getLong("usage", 0);
        long r6 = r4.getLong(ApmTrafficStats.SP_TRAFFIC_ACCU_TIME, 0);
        long r2 = r0 - r8;
        if (r2 > 0) goto L29;
    L21:
        TrafficCollector r3 = this;
        String r5 = "usage";
    L23:
        r3.mInitTrafficBytes = r3.mTrafficStatisticWrapper.getTotalBytes();
        SharedPreferences.Editor r1 = r4.edit();
        r1.putLong("init", r3.mInitTrafficBytes);
        r1.putLong(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, System.currentTimeMillis());
        r1.putLong(r5, 0);
        r1.apply();
        return;
    L29:
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L26
        r11.put(ApmTrafficStats.KEY_TRAFFIC_TOTAL, r2);     // Catch: JSONException -> L26
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L26
        r12.put(ApmTrafficStats.KEY_TRAFFIC_TOTAL_DURATION, ((r6 - r13) / 1000) / 60);     // Catch: JSONException -> L26
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L26
        r7.put(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, r13);     // Catch: JSONException -> L26
        r7.put(ApmTrafficStats.SP_TRAFFIC_ACCU_TIME, r6);     // Catch: JSONException -> L26
        r7.put(ApmTrafficStats.KEY_BIZ_STATS, r4.getLong(ApmTrafficStats.KEY_BIZ_STATS, 0));     // Catch: JSONException -> L26
        r7.put("init", r8);     // Catch: JSONException -> L26
        r5 = "usage";
        r7.put(r5, r0);     // Catch: JSONException -> L20
        String r9 = r4.getString(ApmTrafficStats.KEY_TRAFFIC_BIZ_RECORD_JSON, "");     // Catch: JSONException -> L20
        if (r9 == "") goto L11;
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L20
        r10.put(r5, new JSONArray(r9));     // Catch: JSONException -> L20
        r7.put("detail", r10);     // Catch: JSONException -> L20
    L11:
        PerfData r14 = new PerfData();     // Catch: JSONException -> L20
        r3 = this;
        r14.serviceName(r3.mCollectorSettingKey).extraValues(r11).extraStatus(r12).extraLog(r7);     // Catch: JSONException -> L25
        ApmAlogHelper.feedbackI(TAG, "Init");     // Catch: JSONException -> L25
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L16;
        ApmAlogHelper.feedbackI(TAG, JsonUtils.deepCopy(r14.packLog()).toString());     // Catch: JSONException -> L25
    L16:
        r3.sendPerfLog(r14);     // Catch: JSONException -> L25
        ITrafficCallback r15 = trafficCallback;     // Catch: JSONException -> L25
        if (r15 == null) goto L23;
        r15.onResult(r2);     // Catch: JSONException -> L25
    L20:
        r3 = this;
        goto L23
    L22:
        r3 = this;
        r5 = "usage";
        goto L23
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void onStart() {
        super.onStart();
        if (isBackground() == true) goto L5;
        sBgType = ApmTrafficStats.VALUE_TRAFFIC_STATUS_BG;
    L5:
        long r5 = System.currentTimeMillis();
        long r7 = this.mTrafficStatisticWrapper.getTotalBytes();
        long r9 = this.mTrafficStatisticWrapper.getMobileBackBytes();
        long r11 = this.mTrafficStatisticWrapper.getMobileFrontBytes();
        long r13 = this.mTrafficStatisticWrapper.getWifiBackBytes();
        TrafficStatisticWrapper r15 = this.mTrafficStatisticWrapper;
        String r17 = TAG;
        long r2 = r15.getWifiFrontBytes();
        if (this.mLastTotalBytes != (-1)) goto L9;
        this.mLastTotalBytes = r7;
        this.mLastMobileBackBytes = r9;
        this.mLastMobileFrontBytes = r11;
        this.mLastWIFIBackBytes = r13;
        this.mLastWIFIFrontBytes = r2;
        this.mLastTs = r5;
        return;
    L9:
        JSONArray r6 = new JSONArray();
        long r4 = r7 - this.mLastTotalBytes;
        long r8 = r9 - this.mLastMobileBackBytes;
        long r10 = r11 - this.mLastMobileFrontBytes;
        long r12 = r13 - this.mLastWIFIBackBytes;
        long r14 = r2 - this.mLastWIFIFrontBytes;
        long r16 = this.mTraffic10minutesThresholdBytes;
        if (r16 > 0) goto L12;
    L14:
        long r18 = this.mTraffic10minutesBackThresholdBytes;
        if (r18 > 0) goto L17;
    L22:
        TopK<TrafficUsageModel> r19 = BizTrafficStats.getInstance().getTopPathTraffic();
        if (r19 == null) goto L28;
        if (r19.size() <= 0) goto L28;
        r6.put(ApmTrafficStats.EXCEPTION_LARGE_REQUEST);
    L28:
        if (LruKhighFreqHelper.getInstance().getMaxFreq() <= this.mHighFreqCountThreshold) goto L30;
        r6.put(ApmTrafficStats.EXCEPTION_HIGH_FREQ);
    L30:
        this.mLastTotalBytes = r7;
        this.mLastWIFIFrontBytes = r2;
        this.mLastWIFIBackBytes = r13;
        this.mLastMobileBackBytes = r9;
        this.mLastMobileFrontBytes = r11;
        JSONArray r3 = new JSONArray();
        SamplerHelper.getPerfAllowSwitch(this.mCollectorSettingKey);
        mapToJSONArray(BizTrafficStats.getInstance().getBizTraffic(), ApmTrafficStats.KEY_TRAFFIC_PERIOD, r3);
        mapToJSONArray(BizTrafficStats.getInstance().getBizWifiFrontTraffic(), "wifi_front", r3);
        mapToJSONArray(BizTrafficStats.getInstance().getBizWifiBackTraffic(), "wifi_back", r3);
        mapToJSONArray(BizTrafficStats.getInstance().getBizMobileFrontTraffic(), "mobile_front", r3);
        mapToJSONArray(BizTrafficStats.getInstance().getBizMobileBackTraffic(), "mobile_back", r3);
        JSONObject r20 = new JSONObject();
        if (r3.length() > 0) goto L127;
    L121:
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L90
        r21.put(ApmTrafficStats.KEY_TRAFFIC_PERIOD, r4);     // Catch: JSONException -> L90
        r21.put("mobile_back", r8);     // Catch: JSONException -> L90
        r21.put("mobile_front", r10);     // Catch: JSONException -> L90
        r21.put("wifi_back", r12);     // Catch: JSONException -> L90
        String r110 = "detail";
        r21.put("wifi_front", r14);     // Catch: JSONException -> L89
        ITrafficCallback r22 = trafficCallback;     // Catch: JSONException -> L89
        if (r22 == null) goto L38;
        r22.onResult(r4, r12, r14, r8, r10);     // Catch: JSONException -> L89
    L38:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L89
        PerfData r1 = new PerfData();     // Catch: JSONException -> L89
        JSONObject r23 = new JSONObject();     // Catch: JSONException -> L89
        r23.put(r110, r20);     // Catch: JSONException -> L89
        long r24 = BizTrafficStats.getInstance().getBizIntervalTotalBytes();     // Catch: JSONException -> L89
        String r25 = ApmTrafficStats.KEY_BIZ_STATS;
        r23.put(r25, r24);     // Catch: JSONException -> L87
        TrafficCollector r26 = this;
        r23.put(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, r26.mLastTs);     // Catch: JSONException -> L112
        String r27 = ApmTrafficStats.SP_TRAFFIC_ACCU_TIME;
        r23.put(r27, r5);     // Catch: JSONException -> L110
        r1.serviceName(r26.mCollectorSettingKey).extraStatus(r0).extraValues(r21).extraLog(r23);     // Catch: JSONException -> L110
        if (ApmAlogHelper.isFeedbackALogEnabled() == true) goto L47;
        String r111 = r17;
    L50:
        r26.sendPerfLog(r1);     // Catch: JSONException -> L109
        r26.mLastTs = r5;     // Catch: JSONException -> L109
        if (r6.length() <= 0) goto L86;
        JSONObject r28 = new JSONObject();     // Catch: JSONException -> L109
        r28.put("exception", true);     // Catch: JSONException -> L109
        r28.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, r6);     // Catch: JSONException -> L109
        Map<String, TrafficUsageModel> r29 = LruKhighFreqHelper.getInstance().getHighFreqMap();     // Catch: JSONException -> L109
        if (r29 == null) goto L68;
        Iterator<Map.Entry<String, TrafficUsageModel>> r30 = r29.entrySet().iterator();     // Catch: JSONException -> L109
        JSONArray r112 = new JSONArray();     // Catch: JSONException -> L109
    L56:
        if (r30.hasNext() == false) goto L64;
        Map.Entry<String, TrafficUsageModel> r113 = r30.next();     // Catch: JSONException -> L109
        String r114 = r111;
        String r115 = r110;
        JSONObject r116 = r0;
        JSONObject r117 = r28;
        if (r113.getValue().requestCount <= r26.mHighFreqCountThreshold) goto L63;
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L110
        r31.put("path", r113.getValue().path);     // Catch: JSONException -> L110
        r31.put(ApmTrafficStats.KEY_FREQ, r113.getValue().requestCount);     // Catch: JSONException -> L110
        r31.put(ApmTrafficStats.KEY_BIZ, r113.getValue().clientType);     // Catch: JSONException -> L110
        r112.put(r31);     // Catch: JSONException -> L110
    L63:
        r0 = r116;
        r110 = r115;
        r111 = r114;
        r28 = r117;
        goto L56
    L64:
        JSONObject r118 = r0;
        JSONObject r119 = r28;
        r17 = r111;
        String r120 = r110;
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L67;
        ApmAlogHelper.feedbackI(TRAFFIC_HIGH_FREQ, r112.toString());     // Catch: JSONException -> L110
    L67:
        r20.put(ApmTrafficStats.KEY_HIGH_FREQ, r112);     // Catch: JSONException -> L110
    L69:
        if (r19 == null) goto L81;
        List<E> r32 = r19.sortedList();     // Catch: JSONException -> L110
        if (r32 == 0) goto L81;
        if (r32.size() <= 0) goto L81;
        JSONArray r33 = new JSONArray();     // Catch: JSONException -> L110
        Iterator r34 = r32.iterator();     // Catch: JSONException -> L110
    L76:
        if (r34.hasNext() == false) goto L78;
        TrafficUsageModel r35 = (TrafficUsageModel) r34.next();     // Catch: JSONException -> L110
        JSONObject r121 = new JSONObject();     // Catch: JSONException -> L110
        r121.put("path", r35.path);     // Catch: JSONException -> L110
        r121.put("usage", r35.trafficBytes);     // Catch: JSONException -> L110
        r121.put(ApmTrafficStats.KEY_BIZ, r35.clientType);     // Catch: JSONException -> L110
        r33.put(r121);     // Catch: JSONException -> L110
        goto L76
    L78:
        r20.put(ApmTrafficStats.KEY_LARGE_USAGE, r33);     // Catch: JSONException -> L110
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L81;
        ApmAlogHelper.feedbackI(TRAFFIC_TOPK, r33.toString());     // Catch: JSONException -> L110
    L81:
        JSONObject r36 = r119;
        r36.put(r25, BizTrafficStats.getInstance().getBizIntervalTotalBytes());     // Catch: JSONException -> L110
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L84;
        ApmAlogHelper.feedbackI(EXCEPTION_TYPE, r36.toString());     // Catch: JSONException -> L110
    L84:
        r36.put(r120, r20);     // Catch: JSONException -> L110
        PerfData r37 = new PerfData();     // Catch: JSONException -> L110
        r37.serviceName(r26.mCollectorSettingKey).extraStatus(r118).extraValues(r21).extraLog(r36);     // Catch: JSONException -> L110
        r26.sendPerfLog(r37);     // Catch: JSONException -> L110
        goto L92
    L68:
        r118 = r0;
        r119 = r28;
        r17 = r111;
        r120 = r110;
    L86:
        r17 = r111;
        goto L92
    L47:
        r111 = r17;
        ApmAlogHelper.feedbackI(r111, JsonUtils.deepCopy(r1.packLog()).toString());     // Catch: JSONException -> L109
    L92:
        SharedPreferences.Editor r38 = ApmContext.getContext().getSharedPreferences(ApmTrafficStats.SP_TRAFFIC, 0).edit();
        r38.putLong("usage", r7);
        long r39 = r26.mBizTotalBytes + BizTrafficStats.getInstance().getBizIntervalTotalBytes();
        r26.mBizTotalBytes = r39;
        r38.putLong(r25, r39);
        r38.putLong(r27, System.currentTimeMillis());
        Map<String, BizTrafficStats.BizData> r40 = BizTrafficStats.getInstance().getTotalBizTraffic();
        if (r40 != null) goto L95;
    L103:
        r38.apply();
        if (ApmContext.isDebugMode() == false) goto L106;
        String r41 = r17;
        Log.d(r41, "traffic since app boot: " + (r7 - r26.mInitTrafficBytes));
        Log.d(r41, "traffic stats from biz (include ttnet/ok/httpurl plus trafficStats): " + BizTrafficStats.getInstance().getBizIntervalTotalBytes());
    L106:
        BizTrafficStats.getInstance().clear();
        LruKhighFreqHelper.getInstance().clear();
        return;
    L95:
        if (r40.size() <= 0) goto L103;
        JSONArray r42 = new JSONArray();
        Iterator<Map.Entry<String, BizTrafficStats.BizData>> r43 = r40.entrySet().iterator();
    L98:
        if (r43.hasNext() == false) goto L102;
        JSONObject r44 = r43.next().getValue().toJSONObject();
        r44.put(ApmTrafficStats.KEY_TRAFFIC_CATEGORY, ApmTrafficStats.KEY_TRAFFIC_TOTAL);     // Catch: Exception -> L111
    L101:
        r42.put(r44);
        goto L98
    L102:
        r38.putString(ApmTrafficStats.KEY_TRAFFIC_BIZ_RECORD_JSON, r42.toString());
    L88:
        r27 = ApmTrafficStats.SP_TRAFFIC_ACCU_TIME;
    L87:
        r26 = this;
    L89:
        r26 = this;
    L91:
        r27 = ApmTrafficStats.SP_TRAFFIC_ACCU_TIME;
        r25 = ApmTrafficStats.KEY_BIZ_STATS;
    L90:
        r26 = this;
        goto L91
    L127:
        r20.put("usage", r3);     // Catch: Exception -> L108
        goto L121
    L17:
        if ((r8 + r12) <= r18) goto L22;
        if (TextUtils.equals(sBgType, ApmTrafficStats.VALUE_TRAFFIC_STATUS_BG_NEVER_FRONT) == false) goto L21;
        r6.put(ApmTrafficStats.EXCEPTION_NEVER_FRONT_TOTAL_USAGE);
        goto L22
    L21:
        r6.put(ApmTrafficStats.EXCEPTION_BG_TOTAL_USAGE);
        goto L22
    L12:
        if (r4 <= r16) goto L14;
        r6.put(ApmTrafficStats.EXCEPTION_TOTAL_USAGE);
        goto L22
    }

    private JSONArray mapToJSONArray(Map<String, BizTrafficStats.BizData> r5, String r6, JSONArray r7) {
        if (r5 != null) goto L5;
    L17:
        return null;
    L5:
        if (r5.size() == 0) goto L17;
        Iterator<Map.Entry<String, BizTrafficStats.BizData>> r8 = r5.entrySet().iterator();     // Catch: Exception -> L18
    L9:
        if (r8.hasNext() == false) goto L16;
        JSONObject r1 = r8.next().getValue().toJSONObject(this.recordUsageThreshold);     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r6) == true) goto L14;
        r1.put(ApmTrafficStats.KEY_TRAFFIC_CATEGORY, r6);     // Catch: Exception -> L18
    L14:
        r7.put(r1);     // Catch: Exception -> L18
        goto L9
    L16:
        return r7;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void doConfig(JSONObject r8) {
        super.doConfig(r8);
        if (r8.optInt(SlardarSettingsConsts.PERF_TRAFFIC_CAUSE_ANALYSIS_ENABLE, 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        BizTrafficStats.getInstance().start();
        this.mTraffic10minutesThresholdBytes = (r8.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_THRESHOLD_10_MINUTES_MB, 500) * 1000) * 1000;
        this.mTraffic10minutesBackThresholdBytes = (r8.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_THRESHOLD_10_MINUTES_BG_MB, 500) * 1000) * 1000;
        this.mHighFreqCountThreshold = r8.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_HIGH_FREQ_THRESHOLD, 200);
        BizTrafficStats.getInstance().setSingleRequestTrafficThresholdBytes((r8.optDouble(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_LARGE_USAGE_THRESHOLD_MB, 10.0d) * 1000.0d) * 1000.0d);
        BizTrafficStats.getInstance().setAlogRecordThreshold(r8.optDouble(SlardarSettingsConsts.PERF_TRAFFIC_ALOG_RECORD_THRESHOLD_KB, 100.0d));
    L8:
        this.recordUsageThreshold = r8.optLong(SlardarSettingsConsts.PERF_TRAFFIC_RECORD_USAGE_THRESHOLD_KB, 1) * 1024;
        boolean r1 = SamplerHelper.getPerfAllowSwitch(this.mCollectorSettingKey);
    L10:
        if (cache.isEmpty() == true) goto L26;
        GeneralLegacyEvent r3 = cache.pop();
        String r4 = keys.pop();
        if (r1 == false) goto L14;
    L15:
        CommonEventDeliverer.monitorLegacyEvent(r3);
    L17:
        if (ApmContext.isDebugMode() == false) goto L10;
        String[] r5 = new String[1];
        StringBuilder r6 = new StringBuilder("isSample:key:");
        if (r1 == false) goto L21;
    L24:
        boolean r7 = true;
    L25:
        r5[0] = r6.append(r7).toString();
        Logger.d("Traffic", r5);
        goto L10
    L21:
        if (r8.optInt(r4, 0) == 1) goto L24;
        r7 = false;
        goto L25
    L14:
        if (r8.optInt(r4, 0) != 1) goto L17;
    L26:
        this.config = r8;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        sBgType = ApmTrafficStats.VALUE_TRAFFIC_STATUS_BG;
        this.mTrafficStatisticWrapper.onStatusChange(false);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        this.mTrafficStatisticWrapper.onStatusChange(true);
    }
}
