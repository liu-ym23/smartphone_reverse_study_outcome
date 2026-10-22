package com.bytedance.apm.trace.api;

import com.bytedance.tracing.internal.LogData;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ITracingSpanAbility {
    ITracingSpan addLog(String r1);

    ITracingSpan addLog(String r1, Map<String, String> r2);

    ITracingSpan addTag(String r1, String r2);

    long getFinishTime();

    List<LogData> getLogs();

    long getParentId();

    long getReferenceId();

    long getSpanId();

    String getSpanName();

    long getStartTime();

    Map<String, String> getTags();

    String getThreadName();

    TracingContext getTracingContext();

    void setErrorTag(String r1);

    ITracingSpan setParentId(long r1);

    ITracingSpan setReferenceId(long r1);

    ITracingSpan setThreadName(String r1);
}
