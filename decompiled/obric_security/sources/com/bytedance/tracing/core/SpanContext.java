package com.bytedance.tracing.core;

import com.bytedance.tracing.internal.utils.RandomUtil;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class SpanContext {
    private final String operationName;
    private long parentId;
    private long refId;
    private final String service;
    private final long spanId;
    private final long traceId;
    private Tracer tracer;

    public static final class Builder {
        public Builder() {
        }
    }

    SpanContext(String r1, long r2, long r4, String r6, long r7, long r9) {
        this.service = r1;
        this.traceId = r2;
        this.parentId = r4;
        this.operationName = r6;
        this.spanId = r7;
        this.refId = r9;
    }

    public SpanContext(String r1, String r2) {
        this.service = r1;
        this.operationName = r2;
        this.traceId = RandomUtil.uniqueId();
        this.spanId = RandomUtil.uniqueId();
    }

    public synchronized Tracer getTracer() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.tracer != null) goto L6;
        this.tracer = new Tracer(this);     // Catch: Throwable -> L9
    L6:
        Tracer r0 = this.tracer;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public SpanContext makeChild(String r13) {
        return new SpanContext(this.service, this.traceId, this.spanId, r13, RandomUtil.uniqueId(), 0);
    }

    public SpanContext makeChildAndRef(String r13, long r14) {
        return new SpanContext(this.service, this.traceId, this.spanId, r13, RandomUtil.uniqueId(), r14);
    }

    public String toString() {
        return "SpanContext{service='" + this.service + "', traceId='" + this.traceId + "', parentId='" + this.parentId + "', operationName='" + this.operationName + "', spanId='" + this.spanId + "'}";
    }

    public String getService() {
        return this.service;
    }

    public long getTraceId() {
        return this.traceId;
    }

    public long getParentId() {
        return this.parentId;
    }

    public String getOperationName() {
        return this.operationName;
    }

    public long getSpanId() {
        return this.spanId;
    }

    public long getRefId() {
        return this.refId;
    }
}
