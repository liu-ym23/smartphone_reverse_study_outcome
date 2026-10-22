package com.bytedance.apm.block.trace;

import android.view.FrameMetrics;
import androidx.work.WorkRequest;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.trace.fps.FpsAggregateManger;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.bytedance.apm.util.FpsUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FrameTracer extends AbsTracer {
    private static final String TAG = "FrameTracer";
    private static boolean sNeedMonitorActivity = false;
    private BlockCollectItem blockCollectItem;
    private final ArrayList<RealFpsTracer> fpsTracerList;
    private HashMap<String, FrameCollectItem> map;
    private final long timeSliceMs;

    public static class BlockCollectItem {
        public int blockCount;
        public long blockDuration;
        public int frameBlockCount;

        public BlockCollectItem() {
            this.frameBlockCount = 0;
            this.blockCount = 0;
            this.blockDuration = 0;
        }

        public void collect(long r3, boolean r5) {
            if (r5 == false) goto L4;
            this.frameBlockCount++;
        L4:
            this.blockCount++;
            this.blockDuration += r3;
        }
    }

    private class FrameCollectItem {
        int[] dropLevel;
        int maxDropCount;
        int sumDroppedFrames;
        int sumFrame;
        long sumFrameCost;
        final /* synthetic */ FrameTracer this$0;
        String visibleScene;

        FrameCollectItem(FrameTracer r1, String r2) {
            this.this$0 = r1;
            this.sumFrame = 0;
            this.visibleScene = r2;
            int r3 = FpsUtil.getRefreshRate() - 1;
            this.maxDropCount = r3;
            this.dropLevel = new int[(r3 - 0) + 1];
        }

        void collect(long r4) {
            float r0 = FpsUtil.getFrameIntervalMillis();
            this.sumFrameCost += r4;
            int r5 = Math.min(Math.max((int) (r4 / r0), 0), this.maxDropCount);
            int[] r6 = this.dropLevel;
            r6[r5] = r6[r5] + 1;
            this.sumDroppedFrames += r5;
            this.sumFrame++;
        }

        void report() {
            float r3 = FpsUtil.getFrameIntervalMillis();     // Catch: Throwable -> L13
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L13
            int r4 = 0;
        L5:
            if (r4 > this.maxDropCount) goto L10;
            if (this.dropLevel[r4] <= 0) goto L9;
            r7.put(String.valueOf(r4), this.dropLevel[r4]);     // Catch: Throwable -> L13
        L9:
            r4 = r4 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            FpsAggregateManger.getInstance().aggregate(null, this.visibleScene, (float) (((double) (((this.sumFrame * 100) * FpsUtil.getRefreshRate()) / (this.sumFrame + this.sumDroppedFrames))) / 100.0d));     // Catch: Throwable -> L13
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L13
            r8.put("scene", this.visibleScene);     // Catch: Throwable -> L13
            JSONObject r9 = new JSONObject();     // Catch: Throwable -> L13
            r9.put("total_scroll_time", this.sumFrameCost);     // Catch: Throwable -> L13
            r9.put(CommonKey.KEY_DROP_RATE, 1.0f - ((this.sumFrame * 1.0f) / ((int) (this.sumFrameCost / r3))));     // Catch: Throwable -> L13
            r9.put("refresh_rate", this.maxDropCount + 1);     // Catch: Throwable -> L13
            CommonDataPipeline.getInstance().handle(new PerfData("fps_drop", this.visibleScene, r7, r8, r9));     // Catch: Throwable -> L13
        L11:
            this.sumFrame = 0;
            this.sumDroppedFrames = 0;
            this.sumFrameCost = 0;
        }

        public String toString() {
            return "visibleScene=" + this.visibleScene + ", sumFrame=" + this.sumFrame + ", sumDroppedFrames=" + this.sumDroppedFrames + ", sumFrameCost=" + this.sumFrameCost + ", dropLevel=" + Arrays.toString(this.dropLevel);
        }
    }

    static {
    }

    static /* synthetic */ BlockCollectItem access$000(FrameTracer r0) {
        return r0.blockCollectItem;
    }

    static /* synthetic */ ArrayList access$100(FrameTracer r0) {
        return r0.fpsTracerList;
    }

    public FrameTracer() {
        this.timeSliceMs = WorkRequest.MIN_BACKOFF_MILLIS;
        this.fpsTracerList = new ArrayList();
        this.map = new HashMap();
        this.blockCollectItem = new BlockCollectItem();
        MainThreadMonitor.getMonitor().setFullFpsTracer(true);
        FpsTracer.setFullFpsTracer(true);
    }

    public static void setsNeedMonitorActivity(boolean r0) {
        sNeedMonitorActivity = r0;
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void doFrame(String r1, long r2, long r4) {
        super.doFrame(r1, r2, r4);
        long r5 = r4 - r2;
        doDropCompute(r1, r5);
        int r3 = 0;
    L4:
        if (r3 >= this.fpsTracerList.size()) goto L6;
        this.fpsTracerList.get(r3).doDropCompute(r5);
        r3 = r3 + 1;
        goto L4
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void onFrameMetricsAvailable(String r1, long r2, int r4) {
        doDropCompute(r1, r2);
        int r3 = 0;
    L4:
        if (r3 >= this.fpsTracerList.size()) goto L6;
        this.fpsTracerList.get(r3).doDropCompute(r2);
        r3 = r3 + 1;
        goto L4
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void onFrameMetricsAvailable(String r5, FrameMetrics r6, int r7) {
        int r8 = 0;
        long r0 = (((((r6.getMetric(0) + r6.getMetric(1)) + r6.getMetric(2)) + r6.getMetric(3)) + r6.getMetric(4)) + r6.getMetric(5)) / 1000000;
        doDropCompute(r5, r0);
    L4:
        if (r8 >= this.fpsTracerList.size()) goto L6;
        this.fpsTracerList.get(r8).doDropCompute(r0);
        r8 = r8 + 1;
        goto L4
    }

    public void doBlock(final long r3, final boolean r5) {
        MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new AnonymousClass1(this, r3, r5));
    }

    public void addFpsTracer(final RealFpsTracer r3) {
        MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new AnonymousClass2(this, r3));
    }

    public void removeFpsTracer(final RealFpsTracer r3) {
        MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new AnonymousClass3(this, r3));
    }

    private void doDropCompute(String r4, long r5) {
        if (sNeedMonitorActivity == true) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L16;
        FrameCollectItem r0 = this.map.get(r4);
        if (r0 != null) goto L10;
        r0 = new FrameCollectItem(this, r4);
        this.map.put(r4, r0);
    L10:
        r0.collect(r5);
        if (r0.sumFrameCost < WorkRequest.MIN_BACKOFF_MILLIS) goto L15;
        this.map.remove(r4);
        r0.report();
        return;
    L15:
        return;
    }
}
