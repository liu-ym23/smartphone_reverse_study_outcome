package com.bytedance.apm.perf.traffic;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm.util.TopK;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BizTrafficStats {
    private static final long DEFAULT_LARGE_USAGE_THRESHOLD_BYTES = 102400;
    private static final int LARGE_USAGE_LIMIT_COUNT = 30;
    private static final String TAG = "BizTrafficStats";
    private static final String TRAFFIC_IMAGE_BIZ = "image";
    private double mAlogRecordThreshold;
    private volatile long mBizIntervalTotalBytes;
    private Map<String, BizData> mBizMobileBackTraffic;
    private Map<String, BizData> mBizMobileFrontTraffic;
    private Map<String, BizData> mBizTraffic;
    private Map<String, BizData> mBizWifiBackTraffic;
    private Map<String, BizData> mBizWifiFrontTraffic;
    private Map<String, Map<String, BizData>> mCustomMetricBizTraffic;
    private boolean mEnable;
    private boolean mEnableAlogRecord;
    private double mSingleRequestTrafficThresholdBytes;
    private TopK<TrafficUsageModel> mTopPathTraffic;
    private Map<String, BizData> mTotalBizTraffic;

    class BizData {
        public String biz;
        public Map<String, Long> sourceIdMap;
        final /* synthetic */ BizTrafficStats this$0;
        public long totalUsage;

        public BizData(BizTrafficStats r3, String r4) {
            this.this$0 = r3;
            this.totalUsage = 0;
            this.biz = r4;
            this.sourceIdMap = new HashMap();
        }

        public void appendBytesBySourceId(String r4, long r5) {
            if (this.sourceIdMap.containsKey(r4) == false) goto L5;
            Map<String, Long> r0 = this.sourceIdMap;
            r0.put(r4, Long.valueOf(r0.get(r4).longValue() + r5));
        L6:
            this.totalUsage += r5;
            return;
        L5:
            this.sourceIdMap.put(r4, Long.valueOf(r5));
            goto L6
        }

        public JSONObject toJSONObject() {
            JSONObject r1 = new JSONObject();
            r1.put(ApmTrafficStats.KEY_BIZ, this.biz);     // Catch: JSONException -> L13
            r1.put("usage", this.totalUsage);     // Catch: JSONException -> L13
            JSONArray r2 = new JSONArray();     // Catch: JSONException -> L13
            Map<String, Long> r3 = this.sourceIdMap;     // Catch: JSONException -> L13
            if (r3 != null) goto L6;
        L11:
            r1.put("detail", r2);     // Catch: JSONException -> L13
            goto L12
        L6:
            if (r3.size() <= 0) goto L11;
            Iterator<Map.Entry<String, Long>> r7 = this.sourceIdMap.entrySet().iterator();     // Catch: JSONException -> L13
        L9:
            if (r7.hasNext() == false) goto L11;
            Map.Entry<String, Long> r4 = r7.next();     // Catch: JSONException -> L13
            JSONObject r5 = new JSONObject();     // Catch: JSONException -> L13
            r5.put(ApmTrafficStats.KEY_SOURCE_ID, r4.getKey());     // Catch: JSONException -> L13
            r5.put("usage", r4.getValue());     // Catch: JSONException -> L13
            r2.put(r5);     // Catch: JSONException -> L13
        L12:
            return r1;
        }

        public JSONObject toJSONObject(long r8) {
            JSONObject r1 = new JSONObject();
            r1.put(ApmTrafficStats.KEY_BIZ, this.biz);     // Catch: JSONException -> L15
            r1.put("usage", this.totalUsage);     // Catch: JSONException -> L15
            JSONArray r2 = new JSONArray();     // Catch: JSONException -> L15
            Map<String, Long> r3 = this.sourceIdMap;     // Catch: JSONException -> L15
            if (r3 != null) goto L6;
        L13:
            r1.put("detail", r2);     // Catch: JSONException -> L15
            goto L14
        L6:
            if (r3.size() <= 0) goto L13;
            Iterator<Map.Entry<String, Long>> r7 = this.sourceIdMap.entrySet().iterator();     // Catch: JSONException -> L15
        L9:
            if (r7.hasNext() == false) goto L13;
            Map.Entry<String, Long> r4 = r7.next();     // Catch: JSONException -> L15
            if (r4.getValue().longValue() < r8) goto L9;
            JSONObject r5 = new JSONObject();     // Catch: JSONException -> L15
            r5.put(ApmTrafficStats.KEY_SOURCE_ID, r4.getKey());     // Catch: JSONException -> L15
            r5.put("usage", r4.getValue());     // Catch: JSONException -> L15
            r2.put(r5);     // Catch: JSONException -> L15
        L14:
            return r1;
        }
    }

    private static final class Holder {
        private static final BizTrafficStats sInstance = null;

        private Holder() {
        }

        static /* synthetic */ BizTrafficStats access$000() {
            return sInstance;
        }

        static {
            sInstance = new BizTrafficStats(null);
        }
    }

    @Deprecated
    public void httpImageApiTrafficStats(JSONObject r1) {
    }

    /* synthetic */ BizTrafficStats(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$200(BizTrafficStats r0) {
        return r0.mEnable;
    }

    static /* synthetic */ void access$300(BizTrafficStats r0, String r1, long r2, String r4) {
        r0.appendBizTraffic(r1, r2, r4);
    }

    public static BizTrafficStats getInstance() {
        return Holder.access$000();
    }

    private BizTrafficStats() {
        this.mBizIntervalTotalBytes = 0;
        this.mSingleRequestTrafficThresholdBytes = 102400.0d;
        this.mAlogRecordThreshold = 102400.0d;
    }

    public void start() {
        setEnable(true);
        setEnableAlogRecord(true);
        setSlaListener();
        setCommonDataInnerListener();
    }

    private void setEnable(boolean r1) {
        this.mEnable = r1;
    }

    private void setEnableAlogRecord(boolean r1) {
        this.mEnableAlogRecord = r1;
        ApmAlogHelper.setEnable(r1);
    }

    private void setSlaListener() {
        NetDataPipeline.getInstance().setNetSlaListener(new AnonymousClass1(this));
    }

    private void setCommonDataInnerListener() {
        CommonDataPipeline.getInstance().setCommonDataListener(new AnonymousClass2(this));
    }

    public void setSingleRequestTrafficThresholdBytes(double r1) {
        this.mSingleRequestTrafficThresholdBytes = r1;
    }

    public void setAlogRecordThreshold(double r1) {
        this.mAlogRecordThreshold = r1;
    }

    public void initCustomMetricBizTrafficStats(String r2) {
        if (this.mCustomMetricBizTraffic != null) goto L5;
        this.mCustomMetricBizTraffic = new HashMap();
    L5:
        this.mCustomMetricBizTraffic.put(r2, new HashMap());
    }

    public void clearCustomMetricStats(String r1) {
        Map<String, Map<String, BizData>> r0 = this.mCustomMetricBizTraffic;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    public Map<String, BizData> getCustomMetricBizStats(String r2) {
        if (this.mCustomMetricBizTraffic != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return null;
    L8:
        return this.mCustomMetricBizTraffic.get(r2);
    }

    private void appendBizTraffic(String r5, long r6, String r8) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        boolean r0 = NetUtils.isWifi(ApmContext.getContext());
        ActivityLifecycleService r1 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        if (r1 == null) goto L8;
        boolean r2 = r1.isForeground();
    L10:
        if (this.mBizTraffic != null) goto L13;
        this.mBizTraffic = new HashMap();
    L13:
        if (this.mBizWifiBackTraffic != null) goto L16;
        this.mBizWifiBackTraffic = new HashMap();
    L16:
        if (this.mBizWifiFrontTraffic != null) goto L19;
        this.mBizWifiFrontTraffic = new HashMap();
    L19:
        if (this.mBizMobileBackTraffic != null) goto L22;
        this.mBizMobileBackTraffic = new HashMap();
    L22:
        if (this.mBizMobileFrontTraffic != null) goto L25;
        this.mBizMobileFrontTraffic = new HashMap();
    L25:
        if (this.mBizTraffic.containsKey(r5) == false) goto L27;
        this.mBizTraffic.get(r5).appendBytesBySourceId(r8, r6);
    L28:
        if (r0 == false) goto L34;
        if (r2 == true) goto L34;
        if (this.mBizWifiBackTraffic.containsKey(r5) == false) goto L33;
        this.mBizWifiBackTraffic.get(r5).appendBytesBySourceId(r8, r6);
        goto L34
    L33:
        BizData r3 = new BizData(this, r5);
        r3.appendBytesBySourceId(r8, r6);
        this.mBizWifiBackTraffic.put(r5, r3);
    L34:
        if (r0 == false) goto L40;
        if (r2 == false) goto L40;
        if (this.mBizWifiFrontTraffic.containsKey(r5) == false) goto L39;
        this.mBizWifiFrontTraffic.get(r5).appendBytesBySourceId(r8, r6);
        goto L40
    L39:
        BizData r4 = new BizData(this, r5);
        r4.appendBytesBySourceId(r8, r6);
        this.mBizWifiFrontTraffic.put(r5, r4);
    L40:
        if (r0 == true) goto L46;
        if (r2 == true) goto L46;
        if (this.mBizMobileBackTraffic.containsKey(r5) == false) goto L45;
        this.mBizMobileBackTraffic.get(r5).appendBytesBySourceId(r8, r6);
        goto L46
    L45:
        BizData r7 = new BizData(this, r5);
        r7.appendBytesBySourceId(r8, r6);
        this.mBizMobileBackTraffic.put(r5, r7);
    L46:
        if (r0 == true) goto L53;
        if (r2 == false) goto L53;
        if (this.mBizMobileFrontTraffic.containsKey(r5) == false) goto L51;
        this.mBizMobileFrontTraffic.get(r5).appendBytesBySourceId(r8, r6);
        goto L53
    L51:
        BizData r9 = new BizData(this, r5);
        r9.appendBytesBySourceId(r8, r6);
        this.mBizMobileFrontTraffic.put(r5, r9);
    L53:
        if (this.mTotalBizTraffic != null) goto L56;
        this.mTotalBizTraffic = new HashMap();
    L56:
        if (this.mTotalBizTraffic.containsKey(r5) == false) goto L58;
        this.mTotalBizTraffic.get(r5).appendBytesBySourceId(r8, r6);
    L59:
        Map<String, Map<String, BizData>> r10 = this.mCustomMetricBizTraffic;
        if (r10 == null) goto L68;
        Iterator<Map.Entry<String, Map<String, BizData>>> r11 = r10.entrySet().iterator();
    L63:
        if (r11.hasNext() == false) goto L75;
        Map<String, BizData> r12 = r11.next().getValue();
        if (r12.containsKey(r5) == true) goto L66;
        BizData r13 = new BizData(this, r5);
        r13.appendBytesBySourceId(r8, r6);
        r12.put(r5, r13);
        goto L63
    L66:
        r12.get(r5).appendBytesBySourceId(r8, r6);
        goto L63
    L75:
        return;
    L68:
        return;
    L58:
        BizData r14 = new BizData(this, r5);
        r14.appendBytesBySourceId(r8, r6);
        this.mTotalBizTraffic.put(r5, r14);
        goto L59
    L27:
        BizData r15 = new BizData(this, r5);
        r15.appendBytesBySourceId(r8, r6);
        this.mBizTraffic.put(r5, r15);
        goto L28
    L8:
        r2 = false;
        goto L10
    }

    public Map<String, BizData> getTotalBizTraffic() {
        return this.mTotalBizTraffic;
    }

    public void trafficStats(final long r17, final String r19, final String r20, String r21, JSONObject r22, JSONObject r23) {
        if (this.mEnable == true) goto L5;
        return;
    L5:
        AsyncEventManager.getInstance().post(new AnonymousClass3(this, r20, r17, r19));
        String r13 = "";
        if (this.mEnableAlogRecord == false) goto L23;
        if (r17 <= this.mAlogRecordThreshold) goto L23;
        Object[] r1 = new Object[6];
        r1[0] = Long.valueOf(r17);
        r1[1] = r19;
        r1[2] = r20;
        if (r21 != null) goto L12;
        String r2 = "";
    L13:
        r1[3] = r2;
        if (r22 != null) goto L16;
        String r3 = "";
    L17:
        r1[4] = r3;
        if (r23 != null) goto L20;
        String r4 = "";
    L21:
        r1[5] = r4;
        ApmAlogHelper.i(TAG, String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", r1));
        goto L23
    L20:
        r4 = r23.toString();
        goto L21
    L16:
        r3 = r22.toString();
        goto L17
    L12:
        r2 = r21;
    L23:
        if (ApmContext.isDebugMode() == false) goto L37;
        Object[] r5 = new Object[6];
        r5[0] = Long.valueOf(r17);
        r5[1] = r19;
        r5[2] = r20;
        if (r21 != null) goto L27;
        String r6 = "";
    L28:
        r5[3] = r6;
        if (r22 != null) goto L31;
        String r7 = "";
    L32:
        r5[4] = r7;
        if (r23 == null) goto L36;
        r13 = r23.toString();
    L36:
        r5[5] = r13;
        Log.d(TAG, String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", r5));
        goto L37
    L31:
        r7 = r22.toString();
        goto L32
    L27:
        r6 = r21;
    L37:
        this.mBizIntervalTotalBytes += r17;
    }

    public void httpApiTrafficStats(String r10, JSONObject r11) {
        if (this.mEnable == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L40;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length() == 0) goto L42;
        String r1 = new URL(r10).getPath();     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r1) == false) goto L14;
        return;
    L14:
        String r2 = r11.optString(TrafficConsts.KEY_NET_CONSUME_TYPE, ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET);     // Catch: Throwable -> L35
        JSONObject r3 = r11.optJSONObject("request_log");     // Catch: Throwable -> L35
        if (r3 != null) goto L19;
        String r12 = r11.optString("request_log");     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r12) == true) goto L19;
        r3 = new JSONObject(r12);     // Catch: Throwable -> L35
    L19:
        JSONObject r13 = r3.optJSONObject(ApmTrafficStats.TTNET_RESPONSE);     // Catch: Throwable -> L35
        if (r13 == null) goto L22;
        long r4 = r13.optLong("received_bytes") + r13.optLong("sent_bytes");     // Catch: Throwable -> L35
    L23:
        this.mBizIntervalTotalBytes += r4;     // Catch: Throwable -> L35
        if (r4 > this.mSingleRequestTrafficThresholdBytes) goto L26;
    L29:
        if (TextUtils.isEmpty(r10) == false) goto L38;
    L32:
        appendBizTraffic(r2, r4, r10);
        LruKhighFreqHelper.getInstance().add(r4, r1, r2);
        return;
    L38:
        r10 = Uri.parse(r10).buildUpon().clearQuery().build().toString();     // Catch: Exception -> L34
        goto L32
    L26:
        if (this.mTopPathTraffic != null) goto L28;
        this.mTopPathTraffic = new TopK(30);     // Catch: Throwable -> L35
    L28:
        this.mTopPathTraffic.add(new TrafficUsageModel(r1, r4, r2));     // Catch: Throwable -> L35
        goto L29
    L22:
        r4 = 0;
    L43:
        return;
    L42:
        return;
    }

    public TopK<TrafficUsageModel> getTopPathTraffic() {
        return this.mTopPathTraffic;
    }

    public Map<String, BizData> getBizTraffic() {
        return this.mBizTraffic;
    }

    public Map<String, BizData> getBizMobileBackTraffic() {
        return this.mBizMobileBackTraffic;
    }

    public Map<String, BizData> getBizMobileFrontTraffic() {
        return this.mBizMobileFrontTraffic;
    }

    public Map<String, BizData> getBizWifiFrontTraffic() {
        return this.mBizWifiFrontTraffic;
    }

    public Map<String, BizData> getBizWifiBackTraffic() {
        return this.mBizWifiBackTraffic;
    }

    public long getBizIntervalTotalBytes() {
        return this.mBizIntervalTotalBytes;
    }

    public void clear() {
        Map<String, BizData> r0 = this.mBizTraffic;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Map<String, BizData> r1 = this.mBizWifiBackTraffic;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        Map<String, BizData> r2 = this.mBizWifiFrontTraffic;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        Map<String, BizData> r3 = this.mBizMobileBackTraffic;
        if (r3 == null) goto L14;
        r3.clear();
    L14:
        Map<String, BizData> r4 = this.mBizMobileFrontTraffic;
        if (r4 == null) goto L17;
        r4.clear();
    L17:
        TopK<TrafficUsageModel> r5 = this.mTopPathTraffic;
        if (r5 == null) goto L20;
        r5.clear();
    L20:
        this.mBizIntervalTotalBytes = 0;
    }
}
