package com.bytedance.tracing.core;

import android.text.TextUtils;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.tracing.internal.LogData;
import com.bytedance.tracing.internal.utils.RandomUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class Span {
    private static final String TAG = "Span";
    private SpanContext context;
    private boolean errorTag;
    private long finishTs;
    private List<LogData> logs;
    private String operationName;
    private long parentId;
    private long refId;
    private String serviceName;
    private long spanId;
    private long startTs;
    private Map<String, String> tags;
    private String threadName;
    private long traceId;

    public Span(SpanContext r3) {
        this.context = r3;
        this.traceId = r3.getTraceId();
        this.parentId = r3.getParentId();
        this.serviceName = r3.getService();
        this.operationName = r3.getOperationName();
        this.spanId = r3.getSpanId();
        this.refId = r3.getRefId();
    }

    public Span(String r12, String r13) {
        this(r12, r13, RandomUtil.uniqueId(), 0, RandomUtil.uniqueId(), 0);
    }

    public Span(String r1, String r2, long r3, long r5, long r7, long r9) {
        this.traceId = r3;
        this.parentId = r5;
        this.serviceName = r1;
        this.operationName = r2;
        this.spanId = r7;
        this.refId = r9;
    }

    public Span start() {
        this.startTs = System.currentTimeMillis();
        return this;
    }

    public void finish() {
        this.finishTs = System.currentTimeMillis();
        this.threadName = Thread.currentThread().getName();
        AsyncEventManager.getInstance().post(new AnonymousClass1(this));
    }

    public Span makeChild(String r13) {
        return new Span(this.serviceName, r13, this.traceId, this.spanId, RandomUtil.uniqueId(), 0);
    }

    public Span makeChildAndRef(String r13, long r14) {
        return new Span(this.serviceName, r13, this.traceId, this.spanId, RandomUtil.uniqueId(), r14);
    }

    public Span addReference(long r1) {
        this.refId = r1;
        return this;
    }

    public Span addLog(String r6) {
        if (r6 != null) goto L5;
        return this;
    L5:
        if (this.logs != null) goto L7;
        this.logs = new LinkedList();
    L7:
        this.logs.add(new LogData(System.currentTimeMillis(), r6, null));
        return this;
    }

    public Span addLog(String r5, Map<String, String> r6) {
        if (r5 != null) goto L5;
        return this;
    L5:
        if (this.logs != null) goto L7;
        this.logs = new LinkedList();
    L7:
        this.logs.add(new LogData(System.currentTimeMillis(), r5, r6));
        return this;
    }

    public Span setErrorTag(String r2) {
        return addTag("error", r2);
    }

    public Span addTag(String r2, String r3) {
        if (this.tags != null) goto L6;
        this.tags = new HashMap();
    L6:
        if (TextUtils.equals(r2, "error") == false) goto L8;
        this.errorTag = true;
    L8:
        this.tags.put(r2, r3);
        return this;
    }

    public long getStartTs() {
        return this.startTs;
    }

    public long getFinishTs() {
        return this.finishTs;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public List<LogData> getLogs() {
        return this.logs;
    }

    public boolean isErrorTag() {
        return this.errorTag;
    }

    public long getRefId() {
        return this.refId;
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

    public String getServiceName() {
        return this.serviceName;
    }

    public long getSpanId() {
        return this.spanId;
    }

    public SpanContext getContext() {
        return this.context;
    }

    public String toString() {
        return "Span{traceId='" + this.traceId + "', parentId='" + this.parentId + "', serviceName='" + this.serviceName + "', operationName='" + this.operationName + "', spanId='" + this.spanId + "', refId='" + this.refId + "', startTs=" + this.startTs + ", finishTs=" + this.finishTs + ", threadName='" + this.threadName + "', tags=" + this.tags + ", logs=" + this.logs + ", errorTag=" + this.errorTag + '}';
    }
}
