package com.bytedance.apm.trace.fps;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FpsAggregateManger implements AsyncEventManager.IMonitorTimeTask {
    private static final long AGGREGATE_INTERVAL = 120000;
    private static final String TAG = "FpsAggregateManger";
    private boolean mNeedUploadDeviceFpsInfo;
    private final HashMap<String, AggregateTask> sTimerInfo;

    private static class AggregateTask {
        private long firstTime;
        public Map<String, String> tags;
        private int times;
        public String type;
        public float value;

        AggregateTask(Map<String, String> r1, String r2, float r3) {
            this.tags = r1;
            this.type = r2;
            this.value = r3;
            this.firstTime = System.currentTimeMillis();
            this.times = 1;
        }

        void append(float r2) {
            this.value += r2;
            this.times++;
        }

        float avg() {
            int r0 = this.times;
            if (r0 > 0) goto L5;
            return -1.0f;
        L5:
            return this.value / r0;
        }

        boolean isTimeUp(long r3) {
            if ((r3 - this.firstTime) <= 120000) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static class Holder {
        private static final FpsAggregateManger sInstance = null;

        private Holder() {
        }

        static /* synthetic */ FpsAggregateManger access$000() {
            return sInstance;
        }

        static {
            sInstance = new FpsAggregateManger(null);
        }
    }

    /* synthetic */ FpsAggregateManger(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ HashMap access$200(FpsAggregateManger r0) {
        return r0.sTimerInfo;
    }

    private FpsAggregateManger() {
        this.sTimerInfo = new HashMap();
        this.mNeedUploadDeviceFpsInfo = true;
        AsyncEventManager.getInstance().addTimeTask(this);
    }

    public static FpsAggregateManger getInstance() {
        return Holder.access$000();
    }

    public void aggregate(final Map<String, String> r3, final String r4, final float r5) {
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r4, r3, r5));
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long r13) {
        if (this.sTimerInfo.isEmpty() == true) goto L34;
        Iterator<Map.Entry<String, AggregateTask>> r0 = this.sTimerInfo.entrySet().iterator();
        int r1 = FpsUtil.getRefreshRate();
    L6:
        if (r0.hasNext() == false) goto L47;
        Map.Entry<String, AggregateTask> r2 = r0.next();
        String r6 = r2.getKey();
        AggregateTask r3 = r2.getValue();
        if (r3.isTimeUp(r13) == false) goto L6;
        r0.remove();
        float r4 = r3.avg();
        boolean r10 = false;
        if (ApmContext.isDebugMode() == false) goto L13;
        Logger.i(DebugLogger.TAG_PERF, new String[]{"aggregate fps: " + r6 + " , value: " + r4});
    L13:
        if (r4 <= 0.0f) goto L6;
        float r5 = r1;
        if (r4 <= r5) goto L36;
        r4 = r5;
    L36:
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L35
        r7.put("fps", r4);     // Catch: Exception -> L35
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L35
        r8.put("scene", r6);     // Catch: Exception -> L35
        PerfData r9 = new PerfData("fps", r6, r7, r8, null);     // Catch: Exception -> L35
        CommonDataAssembly.wrapFilters(r9, true);     // Catch: Exception -> L35
        JSONObject r11 = r9.filters;     // Catch: Exception -> L35
        r11.put("refresh_rate", r1);     // Catch: Exception -> L35
        if (this.mNeedUploadDeviceFpsInfo == false) goto L25;
        this.mNeedUploadDeviceFpsInfo = false;     // Catch: Exception -> L35
        r11.put("device_max_refresh_rate", FpsUtil.getDeviceMaxRefreshRate());     // Catch: Exception -> L35
        if (FpsUtil.isUsingMaxRefreshRate() == true) goto L23;
        r10 = true;
    L23:
        r11.put("refresh_rate_restricted", r10);     // Catch: Exception -> L35
    L25:
        if (r3.tags != null) goto L27;
    L32:
        CommonDataPipeline.getInstance().handle(r9);     // Catch: Exception -> L35
        goto L6
    L27:
        if (r3.tags.isEmpty() == true) goto L32;
        Iterator<Map.Entry<String, String>> r12 = r3.tags.entrySet().iterator();     // Catch: Exception -> L35
    L30:
        if (r12.hasNext() == false) goto L32;
        Map.Entry<String, String> r14 = r12.next();     // Catch: Exception -> L35
        r9.filters.put(r14.getKey(), r14.getValue());     // Catch: Exception -> L35
        goto L30
    L47:
        return;
    }
}
