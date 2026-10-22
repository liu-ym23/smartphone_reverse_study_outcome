package com.bytedance.tracing.core;

import com.bytedance.apm.thread.AsyncEventManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class Tracer {
    private long finishTs;
    private String serviceName;
    private long startTs;
    private Map<String, String> tags;
    private long traceId;

    static /* synthetic */ String access$000(Tracer r0) {
        return r0.serviceName;
    }

    static /* synthetic */ long access$100(Tracer r2) {
        return r2.traceId;
    }

    static /* synthetic */ long access$200(Tracer r2) {
        return r2.startTs;
    }

    static /* synthetic */ long access$300(Tracer r2) {
        return r2.finishTs;
    }

    Tracer(SpanContext r3) {
        this.serviceName = r3.getService();
        this.traceId = r3.getTraceId();
    }

    public void start() {
        this.startTs = System.currentTimeMillis();
    }

    public void addTag(String r2, String r3) {
        if (this.tags != null) goto L5;
        this.tags = new ConcurrentHashMap();
    L5:
        this.tags.put(r2, r3);
    }

    public void removeTag(String r1) {
        Map<String, String> r0 = this.tags;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void finish() {
        this.finishTs = System.currentTimeMillis();
        AsyncEventManager.getInstance().post(new AnonymousClass1(this));
    }
}
