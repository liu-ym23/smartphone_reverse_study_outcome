package com.bytedance.apm.trace.model;

import android.util.Log;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.tracing.internal.BatchTracingLogWrapUtils;
import com.bytedance.tracing.internal.TraceSettings;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.tracing.internal.TracingData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BatchTracing extends AbsTracing {
    private AtomicBoolean isFinish;
    private List<JSONObject> spanCacheData;
    private List<Long> spanIdCache;

    public BatchTracing(TracingContext r2) {
        super(r2);
        this.spanCacheData = new CopyOnWriteArrayList();
        this.spanIdCache = new CopyOnWriteArrayList();
        this.isFinish = new AtomicBoolean(false);
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void cancelTrace() {
        this.isFinish.set(true);
        this.spanCacheData.clear();
        this.spanIdCache.clear();
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void endTrace(long r6) {
        if (this.isFinish.get() == false) goto L5;
        return;
    L5:
        this.isFinish.set(true);
        checkTagKey();     // Catch: Throwable -> L11 JSONException -> L13
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L11 JSONException -> L13
        r0.put(TracingConstants.KEY_START_TIMESTAMP, this.startTs);     // Catch: Throwable -> L11 JSONException -> L13
        r0.put(TracingConstants.KEY_END_TIMESTAMP, r6);     // Catch: Throwable -> L11 JSONException -> L13
        r0.put(TracingConstants.KEY_FINISH_FLAG, 1);     // Catch: Throwable -> L11 JSONException -> L13
        r0.put(TracingConstants.KEY_REPORT_MODE, 1);     // Catch: Throwable -> L11 JSONException -> L13
        r0.put(TracingConstants.KEY_INSERT_MODE, 2);     // Catch: Throwable -> L11 JSONException -> L13
        r0.put("log_type", TracingConstants.TRACE_LOG_TYPE);     // Catch: Throwable -> L11 JSONException -> L13
        packageCommonParam(r0, false);     // Catch: Throwable -> L11 JSONException -> L13
        Map<String, String> r7 = this.tags;     // Catch: Throwable -> L11 JSONException -> L13
        if (r7 != null) goto L9;
    L15:
        JSONArray r8 = new JSONArray();     // Catch: Throwable -> L11 JSONException -> L13
        r8.put(r0);     // Catch: Throwable -> L11 JSONException -> L13
        Iterator<JSONObject> r1 = this.spanCacheData.iterator();     // Catch: Throwable -> L11 JSONException -> L13
    L17:
        if (r1.hasNext() == false) goto L19;
        r8.put(r1.next());     // Catch: Throwable -> L11 JSONException -> L13
        goto L17
    L19:
        LaunchAnalysisContext.getInstance().logD(BatchTracingLogWrapUtils.wrapData(r8) + "");     // Catch: Throwable -> L11 JSONException -> L13
        CommonDataPipeline.getInstance().handle(new TracingData(BatchTracingLogWrapUtils.wrapData(r8), this.context.getService(), false, "batch_tracing"));     // Catch: Throwable -> L11 JSONException -> L13
    L20:
        this.spanCacheData.clear();
        return;
    L9:
        if (r7.isEmpty() == true) goto L15;
        r0.put(TracingConstants.KEY_TAGS, new JSONObject(this.tags));     // Catch: Throwable -> L11 JSONException -> L13
    L11:
        th = move-exception;
        this.spanCacheData.clear();
        throw th;
    L13:
        e = move-exception;
        Logger.e("TracingData", new String[]{"error when BatchTracing end trace: " + e.getLocalizedMessage()});     // Catch: Throwable -> L11
        goto L20
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void finishSpan(long r3, JSONObject r5, boolean r6) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.isFinish.get() == false) goto L9;
        LaunchAnalysisContext.getInstance().logE(r5 + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return;
    L9:
        if (this.spanIdCache.contains(Long.valueOf(r3)) == false) goto L22;
        return;
    L22:
    L16:
        th = move-exception;
        Log.e("TracingData", "error: " + th.getLocalizedMessage());
        return;
    L12:
        if (this.context.isForceTrace() == false) goto L14;
    L18:
        packageCommonParam(r5, r6);     // Catch: Throwable -> L16
        this.spanCacheData.add(r5);     // Catch: Throwable -> L16
        this.spanIdCache.add(Long.valueOf(r3));     // Catch: Throwable -> L16
        return;
    L14:
        if (TraceSettings.getInstance().isErrorOrSampleHit(r6, this.context.getService()) != 0) goto L18;
    }
}
