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

/* JADX INFO: loaded from: classes.dex */
public class FpsAggregateManger implements AsyncEventManager.IMonitorTimeTask {
    private static final long AGGREGATE_INTERVAL = 120000;
    private static final String TAG = "FpsAggregateManger";
    private boolean mNeedUploadDeviceFpsInfo;
    private final HashMap<String, AggregateTask> sTimerInfo;

    public static class AggregateTask {
        private long firstTime;
        public Map<String, String> tags;
        private int times;
        public String type;
        public float value;

        public AggregateTask(Map<String, String> r1, String r2, float r3) {
            this.tags = r1;
            this.type = r2;
            this.value = r3;
            this.firstTime = System.currentTimeMillis();
            this.times = 1;
        }

        public void append(float r2) {
            this.value += r2;
            this.times++;
        }

        public float avg() {
            int r0 = this.times;
            if (r0 > 0) goto L5;
            return -1.0f;
        L5:
            return this.value / r0;
        }

        public boolean isTimeUp(long r3) {
            if ((r3 - this.firstTime) <= 120000) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static class Holder {
        private static final FpsAggregateManger sInstance = null;

        static {
            sInstance = new FpsAggregateManger(null);
        }

        private Holder() {
        }

        public static /* synthetic */ FpsAggregateManger access$000() {
            return sInstance;
        }
    }

    public /* synthetic */ FpsAggregateManger(AnonymousClass1 r1) {
        this();
    }

    public static /* synthetic */ HashMap access$200(FpsAggregateManger r0) {
        return r0.sTimerInfo;
    }

    public static FpsAggregateManger getInstance() {
        return Holder.access$000();
    }

    public void aggregate(final Map<String, String> r3, final String r4, final float r5) {
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r4, r3, r5));
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long r11) {
        if (this.sTimerInfo.isEmpty() == true) goto L31;
        Iterator<Map.Entry<String, AggregateTask>> r0 = this.sTimerInfo.entrySet().iterator();
        int r1 = FpsUtil.getRefreshRate();
    L6:
        if (r0.hasNext() == false) goto L44;
        Map.Entry<String, AggregateTask> r2 = r0.next();
        String r6 = r2.getKey();
        AggregateTask r3 = r2.getValue();
        if (r3.isTimeUp(r11) == false) goto L6;
        r0.remove();
        float r4 = r3.avg();
        if (ApmContext.isDebugMode() == false) goto L13;
        Logger.i(DebugLogger.TAG_PERF, new String[]{"aggregate fps: " + r6 + " , value: " + r4});
    L13:
        if (r4 <= 0.0f) goto L6;
        float r5 = r1;
        if (r4 <= r5) goto L33;
        r4 = r5;
    L33:
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L32
        r7.put("fps", r4);     // Catch: Exception -> L32
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L32
        r8.put("scene", r6);     // Catch: Exception -> L32
        PerfData r9 = new PerfData("fps", r6, r7, r8, null);     // Catch: Exception -> L32
        CommonDataAssembly.wrapFilters(r9, true);     // Catch: Exception -> L32
        JSONObject r10 = r9.filters;     // Catch: Exception -> L32
        r10.put("refresh_rate", r1);     // Catch: Exception -> L32
        if (this.mNeedUploadDeviceFpsInfo == false) goto L21;
        this.mNeedUploadDeviceFpsInfo = false;     // Catch: Exception -> L32
        r10.put("device_max_refresh_rate", FpsUtil.getDeviceMaxRefreshRate());     // Catch: Exception -> L32
        r10.put("refresh_rate_restricted", true ^ FpsUtil.isUsingMaxRefreshRate());     // Catch: Exception -> L32
    L21:
        Map<String, String> r12 = r3.tags;     // Catch: Exception -> L32
        if (r12 != null) goto L24;
    L29:
        CommonDataPipeline.getInstance().handle(r9);     // Catch: Exception -> L32
        goto L6
    L24:
        if (r12.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, String>> r13 = r3.tags.entrySet().iterator();     // Catch: Exception -> L32
    L27:
        if (r13.hasNext() == false) goto L29;
        Map.Entry<String, String> r14 = r13.next();     // Catch: Exception -> L32
        r9.filters.put(r14.getKey(), r14.getValue());     // Catch: Exception -> L32
        goto L27
    L44:
        return;
    }

    private FpsAggregateManger() {
        this.sTimerInfo = new HashMap();
        this.mNeedUploadDeviceFpsInfo = true;
        AsyncEventManager.getInstance().addTimeTask(this);
    }
}
