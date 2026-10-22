package com.bytedance.apm.trace.model;

import android.os.Process;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingWindowSpan;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.tracing.internal.TraceSettings;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsTracing {
    protected TracingContext context;
    protected List<String> spanTagKeyList;
    protected long startTs;
    protected Map<String, String> tags;

    public abstract void cancelTrace();

    public abstract void endTrace(long r1);

    public abstract void finishSpan(long r1, JSONObject r3, boolean r4);

    public AbsTracing(TracingContext r2) {
        this.tags = new ConcurrentHashMap();
        this.spanTagKeyList = new CopyOnWriteArrayList();
        this.context = r2;
    }

    public void addTag(String r1, String r2) {
        this.tags.put(r1, r2);
    }

    public void startTrace(long r1) {
        this.startTs = r1;
    }

    public ITracingSpan createSpan(String r3) {
        return new TracingSpan(r3, TracingConstants.VALUE_TRACING, this);
    }

    public ITracingWindowSpan createWindowSpan(String r3) {
        return new TracingSpan(r3, TracingConstants.VALUE_TRACING_WINDOW, this);
    }

    public ITracingSpan createSpan(String r8, long r9) {
        return new TracingSpan(r8, TracingConstants.VALUE_TRACING, this, r9);
    }

    public ITracingWindowSpan createWindowSpan(String r8, long r9) {
        return new TracingSpan(r8, TracingConstants.VALUE_TRACING_WINDOW, this, r9);
    }

    protected void packageCommonParam(JSONObject r5, boolean r6) throws JSONException {
        r5.put("service", this.context.getService());
        r5.put(TracingConstants.KEY_TRACE_ID, this.context.getTraceId() + "");
        if (this.context.isForceTrace() == false) goto L5;
        r5.put("hit_rules", 1);
        r5.put(TracingConstants.KEY_SAMPLE_RATE, 1);
        return;
    L5:
        r5.put("hit_rules", TraceSettings.getInstance().isErrorOrSampleHit(r6, this.context.getService()));
        r5.put(TracingConstants.KEY_SAMPLE_RATE, TraceSettings.getInstance().getSampleRate(this.context.getService()));
    }

    void addSpanTagKey(String r2) {
        if (this.spanTagKeyList.contains(r2) == false) goto L5;
        return;
    L5:
        this.spanTagKeyList.add(r2);
    }

    protected void checkTagKey() {
        if (ApmContext.isDebugMode() == false) goto L10;
        Iterator<String> r0 = this.spanTagKeyList.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        String r1 = r0.next();
        if (this.tags.containsKey(r1) == false) goto L6;
        LaunchAnalysisContext.getInstance().logE("span's tag key can't be same as trace's tag key: " + r1);
        Process.killProcess(Process.myPid());
        goto L6
    L16:
        return;
    }
}
