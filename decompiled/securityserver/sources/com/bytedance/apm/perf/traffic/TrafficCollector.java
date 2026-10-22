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

    public static class Holder {
        private static final TrafficCollector sInstance = null;

        static {
            sInstance = new TrafficCollector(null);
        }

        private Holder() {
        }

        public static /* synthetic */ TrafficCollector access$100() {
            return sInstance;
        }
    }

    static {
        cache = new LimitedQueue(20);
        keys = new LimitedQueue(20);
    }

    public /* synthetic */ TrafficCollector(AnonymousClass1 r1) {
        this();
    }

    public static /* synthetic */ String access$1000(TrafficCollector r0) {
        return r0.mCollectorSettingKey;
    }

    public static /* synthetic */ Map access$200(TrafficCollector r0) {
        return r0.metricTrafficMap;
    }

    public static /* synthetic */ Map access$202(TrafficCollector r0, Map r1) {
        r0.metricTrafficMap = r1;
        return r1;
    }

    public static /* synthetic */ TrafficStatisticWrapper access$300(TrafficCollector r0) {
        return r0.mTrafficStatisticWrapper;
    }

    public static /* synthetic */ Map access$400(TrafficCollector r0) {
        return r0.metricWifiTrafficMap;
    }

    public static /* synthetic */ Map access$402(TrafficCollector r0, Map r1) {
        r0.metricWifiTrafficMap = r1;
        return r1;
    }

    public static /* synthetic */ Map access$500(TrafficCollector r0) {
        return r0.metricMobileTrafficMap;
    }

    public static /* synthetic */ Map access$502(TrafficCollector r0, Map r1) {
        r0.metricMobileTrafficMap = r1;
        return r1;
    }

    public static /* synthetic */ String access$600(TrafficCollector r0) {
        return r0.mCollectorSettingKey;
    }

    public static /* synthetic */ JSONObject access$700(TrafficCollector r0) {
        return r0.config;
    }

    public static /* synthetic */ LimitedQueue access$800() {
        return cache;
    }

    public static /* synthetic */ LimitedQueue access$900() {
        return keys;
    }

    public static TrafficCollector getInstance() {
        return Holder.access$100();
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

    public static void setCallback(ITrafficCallback r0) {
        trafficCallback = r0;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject r8) {
        super.doConfig(r8);
        if (r8.optInt(SlardarSettingsConsts.PERF_TRAFFIC_CAUSE_ANALYSIS_ENABLE, 0) != 1) goto L5;
        BizTrafficStats.getInstance().start();
        this.mTraffic10minutesThresholdBytes = r8.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_THRESHOLD_10_MINUTES_MB, 500) * 1000000;
        this.mTraffic10minutesBackThresholdBytes = r8.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_THRESHOLD_10_MINUTES_BG_MB, 500) * 1000000;
        this.mHighFreqCountThreshold = r8.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_HIGH_FREQ_THRESHOLD, 200);
        BizTrafficStats.getInstance().setSingleRequestTrafficThresholdBytes((r8.optDouble(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_LARGE_USAGE_THRESHOLD_MB, 10.0d) * 1000.0d) * 1000.0d);
        BizTrafficStats.getInstance().setAlogRecordThreshold(r8.optDouble(SlardarSettingsConsts.PERF_TRAFFIC_ALOG_RECORD_THRESHOLD_KB, 100.0d));
    L5:
        this.recordUsageThreshold = r8.optLong(SlardarSettingsConsts.PERF_TRAFFIC_RECORD_USAGE_THRESHOLD_KB, 1) * 1024;
        boolean r0 = SamplerHelper.getPerfAllowSwitch(this.mCollectorSettingKey);
    L7:
        if (cache.isEmpty() == true) goto L23;
        GeneralLegacyEvent r3 = cache.pop();
        String r4 = keys.pop();
        if (r0 == false) goto L11;
    L12:
        CommonEventDeliverer.monitorLegacyEvent(r3);
    L14:
        if (ApmContext.isDebugMode() == false) goto L7;
        StringBuilder r5 = new StringBuilder("isSample:key:");
        if (r0 == false) goto L18;
    L21:
        boolean r6 = true;
    L22:
        r5.append(r6);
        Logger.d("Traffic", new String[]{r5.toString()});
        goto L7
    L18:
        if (r8.optInt(r4, 0) == 1) goto L21;
        r6 = false;
        goto L22
    L11:
        if (r8.optInt(r4, 0) != 1) goto L14;
    L23:
        this.config = r8;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public boolean isTimerMonitor() {
        return true;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        this.mTrafficStatisticWrapper.onStatusChange(true);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        sBgType = ApmTrafficStats.VALUE_TRAFFIC_STATUS_BG;
        this.mTrafficStatisticWrapper.onStatusChange(false);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onInit() {
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
        String r1 = "usage";
    L23:
        r3.mInitTrafficBytes = r3.mTrafficStatisticWrapper.getTotalBytes();
        SharedPreferences.Editor r5 = r4.edit();
        r5.putLong("init", r3.mInitTrafficBytes);
        r5.putLong(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, System.currentTimeMillis());
        r5.putLong(r1, 0);
        r5.apply();
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
        r1 = "usage";
        r7.put(r1, r0);     // Catch: JSONException -> L11
        String r9 = r4.getString(ApmTrafficStats.KEY_TRAFFIC_BIZ_RECORD_JSON, "");     // Catch: JSONException -> L11
        if (r9 == "") goto L12;
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L11
        r10.put(r1, new JSONArray(r9));     // Catch: JSONException -> L11
        r7.put("detail", r10);     // Catch: JSONException -> L11
    L12:
        PerfData r14 = new PerfData();     // Catch: JSONException -> L11
        r3 = this;
        r14.serviceName(r3.mCollectorSettingKey).extraValues(r11).extraStatus(r12).extraLog(r7);     // Catch: JSONException -> L25
        ApmAlogHelper.feedbackI(TAG, "Init");     // Catch: JSONException -> L25
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L17;
        ApmAlogHelper.feedbackI(TAG, JsonUtils.deepCopy(r14.packLog()).toString());     // Catch: JSONException -> L25
    L17:
        r3.sendPerfLog(r14);     // Catch: JSONException -> L25
        ITrafficCallback r15 = trafficCallback;     // Catch: JSONException -> L25
        if (r15 == null) goto L23;
        r15.onResult(r2);     // Catch: JSONException -> L25
    L11:
        r3 = this;
        goto L23
    L22:
        r3 = this;
        r1 = "usage";
        goto L23
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
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
        String r16 = TAG;
        long r3 = r15.getWifiFrontBytes();
        if (this.mLastTotalBytes != (-1)) goto L9;
        this.mLastTotalBytes = r7;
        this.mLastMobileBackBytes = r9;
        this.mLastMobileFrontBytes = r11;
        this.mLastWIFIBackBytes = r13;
        this.mLastWIFIFrontBytes = r3;
        this.mLastTs = r5;
        return;
    L9:
        JSONArray r1 = new JSONArray();
        long r6 = r7 - this.mLastTotalBytes;
        long r8 = r9 - this.mLastMobileBackBytes;
        long r10 = r11 - this.mLastMobileFrontBytes;
        long r12 = r13 - this.mLastWIFIBackBytes;
        long r14 = r3 - this.mLastWIFIFrontBytes;
        long r17 = this.mTraffic10minutesThresholdBytes;
        if (r17 > 0) goto L12;
    L14:
        long r18 = this.mTraffic10minutesBackThresholdBytes;
        if (r18 > 0) goto L17;
    L22:
        TopK<TrafficUsageModel> r2 = BizTrafficStats.getInstance().getTopPathTraffic();
        if (r2 == null) goto L28;
        if (r2.size() <= 0) goto L28;
        r1.put(ApmTrafficStats.EXCEPTION_LARGE_REQUEST);
    L28:
        if (LruKhighFreqHelper.getInstance().getMaxFreq() <= this.mHighFreqCountThreshold) goto L30;
        r1.put(ApmTrafficStats.EXCEPTION_HIGH_FREQ);
    L30:
        this.mLastTotalBytes = r7;
        this.mLastWIFIFrontBytes = r3;
        this.mLastWIFIBackBytes = r13;
        this.mLastMobileBackBytes = r9;
        this.mLastMobileFrontBytes = r11;
        JSONArray r4 = new JSONArray();
        SamplerHelper.getPerfAllowSwitch(this.mCollectorSettingKey);
        mapToJSONArray(BizTrafficStats.getInstance().getBizTraffic(), ApmTrafficStats.KEY_TRAFFIC_PERIOD, r4);
        mapToJSONArray(BizTrafficStats.getInstance().getBizWifiFrontTraffic(), "wifi_front", r4);
        mapToJSONArray(BizTrafficStats.getInstance().getBizWifiBackTraffic(), "wifi_back", r4);
        mapToJSONArray(BizTrafficStats.getInstance().getBizMobileFrontTraffic(), "mobile_front", r4);
        Map<String, BizTrafficStats.BizData> r19 = BizTrafficStats.getInstance().getBizMobileBackTraffic();
        String r32 = ApmTrafficStats.SP_TRAFFIC_ACCU_TIME;
        mapToJSONArray(r19, "mobile_back", r4);
        JSONObject r20 = new JSONObject();
        if (r4.length() > 0) goto L111;
    L107:
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L36
        r21.put(ApmTrafficStats.KEY_TRAFFIC_PERIOD, r6);     // Catch: JSONException -> L36
        r21.put("mobile_back", r8);     // Catch: JSONException -> L36
        r21.put("mobile_front", r10);     // Catch: JSONException -> L36
        r21.put("wifi_back", r12);     // Catch: JSONException -> L36
        r21.put("wifi_front", r14);     // Catch: JSONException -> L36
        ITrafficCallback r22 = trafficCallback;     // Catch: JSONException -> L36
        if (r22 == null) goto L37;
        r22.onResult(r6, r12, r14, r8, r10);     // Catch: JSONException -> L36
    L37:
        JSONObject r23 = new JSONObject();     // Catch: JSONException -> L36
        PerfData r24 = new PerfData();     // Catch: JSONException -> L36
        JSONObject r25 = new JSONObject();     // Catch: JSONException -> L36
        String r26 = "detail";
        r25.put(r26, r20);     // Catch: JSONException -> L36
        long r27 = BizTrafficStats.getInstance().getBizIntervalTotalBytes();     // Catch: JSONException -> L36
        String r110 = ApmTrafficStats.KEY_BIZ_STATS;
        r25.put(r110, r27);     // Catch: JSONException -> L103
        r25.put(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, this.mLastTs);     // Catch: JSONException -> L103
        String r28 = r32;
        r25.put(r28, r5);     // Catch: JSONException -> L46
        r24.serviceName(this.mCollectorSettingKey).extraStatus(r23).extraValues(r21).extraLog(r25);     // Catch: JSONException -> L46
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L47;
        String r29 = r16;
        ApmAlogHelper.feedbackI(r29, JsonUtils.deepCopy(r24.packLog()).toString());     // Catch: JSONException -> L102
    L48:
        sendPerfLog(r24);     // Catch: JSONException -> L102
        this.mLastTs = r5;     // Catch: JSONException -> L102
        if (r1.length() <= 0) goto L84;
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L102
        r30.put("exception", true);     // Catch: JSONException -> L102
        r30.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, r1);     // Catch: JSONException -> L102
        Map<String, TrafficUsageModel> r31 = LruKhighFreqHelper.getInstance().getHighFreqMap();     // Catch: JSONException -> L102
        if (r31 == null) goto L66;
        Iterator<Map.Entry<String, TrafficUsageModel>> r33 = r31.entrySet().iterator();     // Catch: JSONException -> L102
        JSONArray r111 = new JSONArray();     // Catch: JSONException -> L102
    L54:
        if (r33.hasNext() == false) goto L62;
        Map.Entry<String, TrafficUsageModel> r112 = r33.next();     // Catch: JSONException -> L102
        String r34 = r28;
        String r113 = r29;
        Iterator<Map.Entry<String, TrafficUsageModel>> r114 = r33;
        String r115 = r26;
        if (r112.getValue().requestCount <= this.mHighFreqCountThreshold) goto L61;
        JSONObject r35 = new JSONObject();     // Catch: JSONException -> L103
        r35.put(ApmTrafficStats.KEY_PATH, r112.getValue().path);     // Catch: JSONException -> L103
        r35.put(ApmTrafficStats.KEY_FREQ, r112.getValue().requestCount);     // Catch: JSONException -> L103
        r35.put(ApmTrafficStats.KEY_BIZ, r112.getValue().clientType);     // Catch: JSONException -> L103
        r111.put(r35);     // Catch: JSONException -> L103
    L61:
        r33 = r114;
        r29 = r113;
        r26 = r115;
        r28 = r34;
        goto L54
    L62:
        String r116 = r26;
        r32 = r28;
        r16 = r29;
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L65;
        ApmAlogHelper.feedbackI(TRAFFIC_HIGH_FREQ, r111.toString());     // Catch: JSONException -> L103
    L65:
        r20.put(ApmTrafficStats.KEY_HIGH_FREQ, r111);     // Catch: JSONException -> L103
    L67:
        if (r2 == null) goto L79;
        List<E> r36 = r2.sortedList();     // Catch: JSONException -> L103
        if (r36 == 0) goto L79;
        if (r36.size() <= 0) goto L79;
        JSONArray r37 = new JSONArray();     // Catch: JSONException -> L103
        Iterator r38 = r36.iterator();     // Catch: JSONException -> L103
    L74:
        if (r38.hasNext() == false) goto L76;
        TrafficUsageModel r39 = (TrafficUsageModel) r38.next();     // Catch: JSONException -> L103
        JSONObject r40 = new JSONObject();     // Catch: JSONException -> L103
        r40.put(ApmTrafficStats.KEY_PATH, r39.path);     // Catch: JSONException -> L103
        r40.put("usage", r39.trafficBytes);     // Catch: JSONException -> L103
        r40.put(ApmTrafficStats.KEY_BIZ, r39.clientType);     // Catch: JSONException -> L103
        r37.put(r40);     // Catch: JSONException -> L103
        goto L74
    L76:
        r20.put(ApmTrafficStats.KEY_LARGE_USAGE, r37);     // Catch: JSONException -> L103
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L79;
        ApmAlogHelper.feedbackI(TRAFFIC_TOPK, r37.toString());     // Catch: JSONException -> L103
    L79:
        r30.put(r110, BizTrafficStats.getInstance().getBizIntervalTotalBytes());     // Catch: JSONException -> L103
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L82;
        ApmAlogHelper.feedbackI(EXCEPTION_TYPE, r30.toString());     // Catch: JSONException -> L103
    L82:
        r30.put(r116, r20);     // Catch: JSONException -> L103
        PerfData r41 = new PerfData();     // Catch: JSONException -> L103
        r41.serviceName(this.mCollectorSettingKey).extraStatus(r23).extraValues(r21).extraLog(r30);     // Catch: JSONException -> L103
        sendPerfLog(r41);     // Catch: JSONException -> L103
        goto L85
    L66:
        r116 = r26;
        r32 = r28;
        r16 = r29;
    L84:
        r32 = r28;
        r16 = r29;
        goto L85
    L47:
        r29 = r16;
    L46:
        r32 = r28;
    L85:
        SharedPreferences.Editor r42 = ApmContext.getContext().getSharedPreferences(ApmTrafficStats.SP_TRAFFIC, 0).edit();
        r42.putLong("usage", r7);
        long r43 = BizTrafficStats.getInstance().getBizIntervalTotalBytes() + this.mBizTotalBytes;
        this.mBizTotalBytes = r43;
        r42.putLong(r110, r43);
        r42.putLong(r32, System.currentTimeMillis());
        Map<String, BizTrafficStats.BizData> r44 = BizTrafficStats.getInstance().getTotalBizTraffic();
        if (r44 != null) goto L88;
    L96:
        r42.apply();
        if (ApmContext.isDebugMode() == false) goto L99;
        String r45 = r16;
        Log.d(r45, "traffic since app boot: " + (r7 - this.mInitTrafficBytes));
        Log.d(r45, "traffic stats from biz (include ttnet/ok/httpurl plus trafficStats): " + BizTrafficStats.getInstance().getBizIntervalTotalBytes());
    L99:
        BizTrafficStats.getInstance().clear();
        LruKhighFreqHelper.getInstance().clear();
        return;
    L88:
        if (r44.size() <= 0) goto L96;
        JSONArray r46 = new JSONArray();
        Iterator<Map.Entry<String, BizTrafficStats.BizData>> r47 = r44.entrySet().iterator();
    L91:
        if (r47.hasNext() == false) goto L95;
        JSONObject r48 = r47.next().getValue().toJSONObject();
        r48.put(ApmTrafficStats.KEY_TRAFFIC_CATEGORY, ApmTrafficStats.KEY_TRAFFIC_TOTAL);     // Catch: Exception -> L104
    L94:
        r46.put(r48);
        goto L91
    L95:
        r42.putString(ApmTrafficStats.KEY_TRAFFIC_BIZ_RECORD_JSON, r46.toString());
    L36:
        r110 = ApmTrafficStats.KEY_BIZ_STATS;
        goto L85
    L111:
        r20.put("usage", r4);     // Catch: Exception -> L101
        goto L107
    L17:
        if ((r8 + r12) <= r18) goto L22;
        if (TextUtils.equals(sBgType, ApmTrafficStats.VALUE_TRAFFIC_STATUS_BG_NEVER_FRONT) == false) goto L21;
        r1.put(ApmTrafficStats.EXCEPTION_NEVER_FRONT_TOTAL_USAGE);
        goto L22
    L21:
        r1.put(ApmTrafficStats.EXCEPTION_BG_TOTAL_USAGE);
        goto L22
    L12:
        if (r6 <= r17) goto L14;
        r1.put(ApmTrafficStats.EXCEPTION_TOTAL_USAGE);
        goto L22
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
    public long workInternalMs() {
        return 600000;
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
}
