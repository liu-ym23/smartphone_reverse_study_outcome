package com.bytedance.apm.event;

import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FpsDropEvent extends PerfBaseEvent {
    private static final String FPS_DROP_SERVICE = "fps_drop";
    private static final String KEY_DROP_RATE = "drop_time_rate";
    private static final String KEY_REFRESH_RATE = "refresh_rate";
    private static final String KEY_SCENE = "scene";
    public static final int MIN_DROP_FRAME = 0;
    private static final String SCROLL_TIME = "total_scroll_time";
    private int[] dropLevel;
    private int maxDropCount;
    private int sumFrame;
    private long sumFrameCost;
    private String visibleScene;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "fps_drop";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return false;
    }

    public FpsDropEvent(int r1, int[] r2, int r3, String r4, long r5) {
        this.maxDropCount = r1;
        this.dropLevel = r2;
        this.sumFrame = r3;
        this.visibleScene = r4;
        this.sumFrameCost = r5;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L11
        int r1 = 0;
    L4:
        if (r1 > this.maxDropCount) goto L17;
        if (this.dropLevel[r1] <= 0) goto L8;
        r0.put(String.valueOf(r1), this.dropLevel[r1]);     // Catch: Throwable -> L11
    L8:
        r1 = r1 + 1;
        goto L4
    L17:
        return null;
    L9:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraStatus() {
        new JSONObject().put("scene", this.visibleScene);     // Catch: Throwable -> L5
        return null;
    L8:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject createRootJSONObject() {
        float r0 = FpsUtil.getFrameIntervalMillis();     // Catch: Throwable -> L5
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
        r1.put("total_scroll_time", this.sumFrameCost);     // Catch: Throwable -> L5
        r1.put("drop_time_rate", 1.0f - ((this.sumFrame * 1.0f) / ((int) (this.sumFrameCost / r0))));     // Catch: Throwable -> L5
        r1.put("refresh_rate", this.maxDropCount + 1);     // Catch: Throwable -> L5
    L4:
        return super.createRootJSONObject();
    }
}
