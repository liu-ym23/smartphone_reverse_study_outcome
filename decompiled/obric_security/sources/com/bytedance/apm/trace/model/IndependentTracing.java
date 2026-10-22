package com.bytedance.apm.trace.model;

import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.tracing.internal.TracingData;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IndependentTracing extends AbsTracing {
    private AtomicBoolean isFinish;

    public IndependentTracing(TracingContext r2) {
        super(r2);
        this.isFinish = new AtomicBoolean(false);
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void endTrace(long r4) {
        if (this.isFinish.get() == false) goto L5;
        return;
    L5:
        this.isFinish.set(true);
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L8
        r5.put(TracingConstants.KEY_START_TIMESTAMP, this.startTs);     // Catch: JSONException -> L8
        r5.put(TracingConstants.KEY_END_TIMESTAMP, System.currentTimeMillis());     // Catch: JSONException -> L8
        r5.put(TracingConstants.KEY_FINISH_FLAG, 1);     // Catch: JSONException -> L8
        r5.put(TracingConstants.KEY_REPORT_MODE, 0);     // Catch: JSONException -> L8
        r5.put("log_type", TracingConstants.TRACE_LOG_TYPE);     // Catch: JSONException -> L8
        packageCommonParam(r5, false);     // Catch: JSONException -> L8
        CommonDataPipeline.getInstance().handle(new TracingData(r5, this.context.getService(), false, "tracing"));     // Catch: JSONException -> L8
        return;
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void finishSpan(long r2, JSONObject r4, boolean r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.isFinish.get() == false) goto L10;
        return;
    L10:
        packageCommonParam(r4, r5);     // Catch: JSONException -> L9
        CommonDataPipeline.getInstance().handle(new TracingData(r4, this.context.getService(), r5, "tracing"));     // Catch: JSONException -> L9
        return;
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void cancelTrace() {
        this.isFinish.set(true);
    }
}
